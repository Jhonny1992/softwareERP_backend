package pe.com.consult.security.service;

import org.springframework.stereotype.Service;
import pe.com.consult.security.dto.request.RequestUser;
import pe.com.consult.security.persistence.entity.security.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    User registerOneCustomer(RequestUser requestUser);
    Optional<User> findOneByUserName(String username);

    List<String> findRoleNamesByUserId(long id);
}
