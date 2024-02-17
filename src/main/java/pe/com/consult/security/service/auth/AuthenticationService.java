package pe.com.consult.security.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pe.com.consult.security.dto.auth.AuthenticationRequest;
import pe.com.consult.security.dto.auth.UserRequest;
import pe.com.consult.security.dto.request.RequestUser;
import pe.com.consult.security.dto.auth.AuthenticationResponse;
import pe.com.consult.security.dto.response.ResponseUser;
import pe.com.consult.security.exception.ObjectNotFoundException;
import pe.com.consult.security.persistence.entity.security.Role;
import pe.com.consult.security.persistence.entity.security.User;
import pe.com.consult.security.service.UserService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;


    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseUser registerOneCUstomer(RequestUser requestUser) {

        User user = userService.registerOneCustomer(requestUser);

        ResponseUser userDTO = new ResponseUser();
        userDTO.setId(user.getId());
        userDTO.setName(user.getFirstName());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(Collections.singletonList("ROLE_CUSTOMER"));

        String jwt = jwtService.generateToken(user, generateExtraClaims(user, userDTO.getRole()));
        userDTO.setJwt(jwt);

        return userDTO;
    }

    private Map<String, Object> generateExtraClaims(User user, List<String> role) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name",user.getFirstName() + " " + user.getLastNameFirst());
        extraClaims.put("role",role);
        extraClaims.put("authorities",user.getAuthorities());
        return extraClaims;
    }

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()
        );
        authenticationManager.authenticate(authentication);
        User user = userService.findOneByUserName(authenticationRequest.getUsername()).get();
        List<String> role = userService.findRoleNamesByUserId(user.getId());
        String jwt = jwtService.generateToken(user, generateExtraClaims((User) user, role));

        AuthenticationResponse authResp = new AuthenticationResponse();
        authResp.setJwt(jwt);

        return authResp;
    }

    public boolean validateToker(String jwt){
        try {

            jwtService.extractUsername(jwt);
            return true;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public User findLoggedInUser() {

        Authentication auth = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();


            String username = (String) auth.getPrincipal();

            return userService.findOneByUserName(username)
                    .orElseThrow(() -> new ObjectNotFoundException("User not found"));

    }
}
