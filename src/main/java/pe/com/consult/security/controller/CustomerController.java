package pe.com.consult.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.consult.security.dto.request.RequestUser;
import pe.com.consult.security.dto.response.ResponseUser;
import pe.com.consult.security.service.auth.AuthenticationService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<ResponseUser> registerOne(@RequestBody RequestUser requestUser){

        ResponseUser responseUser = authenticationService.registerOneCUstomer(requestUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }



}
