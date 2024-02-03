package pe.com.consult.security.service;

import org.springframework.stereotype.Service;
import pe.com.consult.security.persistence.entity.security.Role;

@Service
public interface RoleService {
    Role findAllById(Long idCustomer);

    Role getById(Long idCustomer);
}
