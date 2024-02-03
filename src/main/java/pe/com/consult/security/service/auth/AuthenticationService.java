package pe.com.consult.security.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.consult.security.dto.request.RequestUser;
import pe.com.consult.security.dto.response.ResponseUser;
import pe.com.consult.security.persistence.entity.security.Role;
import pe.com.consult.security.persistence.entity.security.User;
import pe.com.consult.security.service.RoleService;
import pe.com.consult.security.service.UserService;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    public ResponseUser registerOneCUstomer(RequestUser requestUser) {

        User user = userService.registerOneCustomer(requestUser);

        ResponseUser userDTO = new ResponseUser();
        userDTO.setId(user.getId());
        userDTO.setName(user.getFirstName());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole("ROLE_CUSTOMER");

        String jwt = jwtService.generateToken(user, generateExtraClaims(user, userDTO.getRole()));
        userDTO.setJwt(jwt);

        return userDTO;
    }

    private Map<String, Object> generateExtraClaims(User user, String role) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name",user.getFirstName() + " " + user.getLastNameFirst());
        extraClaims.put("role",role);
        extraClaims.put("authorities",user.getAuthorities());
        return extraClaims;
    }
}
