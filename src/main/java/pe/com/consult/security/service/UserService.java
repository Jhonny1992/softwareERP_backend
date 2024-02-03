package pe.com.consult.security.service;

import org.springframework.stereotype.Service;
import pe.com.consult.security.dto.request.RequestUser;
import pe.com.consult.security.persistence.entity.security.User;

@Service
public interface UserService {


    User registerOneCustomer(RequestUser requestUser);
}
