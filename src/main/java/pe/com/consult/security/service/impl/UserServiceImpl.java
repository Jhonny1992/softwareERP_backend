package pe.com.consult.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pe.com.consult.security.dto.request.RequestUser;
import pe.com.consult.security.exception.InvalidPasswordException;
import pe.com.consult.security.persistence.entity.security.Role;
import pe.com.consult.security.persistence.entity.security.RoleUser;
import pe.com.consult.security.persistence.entity.security.RoleUserPK;
import pe.com.consult.security.persistence.entity.security.User;
import pe.com.consult.security.persistence.repository.RoleRepository;
import pe.com.consult.security.persistence.repository.RoleUserRepository;
import pe.com.consult.security.persistence.repository.UserRepository;
import pe.com.consult.security.service.UserService;
import pe.com.consult.security.service.util.GeneratorCodeService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GeneratorCodeService generatorCodeService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleUserRepository roleUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerOneCustomer(RequestUser requestUser) {

        validatePassword(requestUser);

        User lastUser = userRepository.findTopByOrderByIdDesc();
        int lastId = (lastUser != null) ? Integer.parseInt(lastUser.getCodeUser().substring(1)) + 1 : 1;
        String id = generatorCodeService.generatorCode("U",lastId);

        User user = User.builder()
                .codeUser(id)
                .firstName(requestUser.getFirstname())
                .lastNameFirst(requestUser.getLastname())
                .password(passwordEncoder.encode(requestUser.getPassword()))
                .userName(requestUser.getUsername())
                .userStatus(true).build();

        RoleUserPK roleUserPK = RoleUserPK.builder()
                .userId(user.getId())
                .roleId(2L).build();

        Role role = roleRepository.findById(2L).orElseThrow(() -> new RuntimeException("Role not found"));

        RoleUser roleUser = RoleUser.builder()
                .roleUserPK(roleUserPK)
                .user(user)
                .role(role)
                .build();

        user.setRoles(Arrays.asList(roleUser));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findOneByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public List<String> findRoleNamesByUserId(long id) {
        return userRepository.findRoleNamesByUserId(id);
    }

    private void validatePassword(RequestUser requestUser) {

        if(!StringUtils.hasText(requestUser.getPassword()) || !StringUtils.hasText(requestUser.getRepeatPassword())){
            throw new InvalidPasswordException("Password don't match");
        }
        if(!requestUser.getPassword().equals(requestUser.getRepeatPassword())){
            throw new InvalidPasswordException("Password don't match");
        }
    }
}
