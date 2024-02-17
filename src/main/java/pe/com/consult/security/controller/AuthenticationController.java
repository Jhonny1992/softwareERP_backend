package pe.com.consult.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.consult.security.dto.auth.AuthenticationRequest;
import pe.com.consult.security.dto.auth.AuthenticationResponse;
import pe.com.consult.security.persistence.entity.security.User;
import pe.com.consult.security.service.auth.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){

        AuthenticationResponse resp = authenticationService.login(authenticationRequest);

        return ResponseEntity.ok(resp);

    }

    @GetMapping("/profile")
    public ResponseEntity<User>  findMyProfile(){
        User user = authenticationService.findLoggedInUser();
        return ResponseEntity.ok(user);
    }
}
