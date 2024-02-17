package pe.com.consult.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.consult.security.persistence.entity.security.Role;
import pe.com.consult.security.persistence.repository.RoleRepository;
import pe.com.consult.security.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;


    @Override
    public Role findAllById(Long idCustomer) {
        return roleRepository.getById(idCustomer);
    }

    @Override
    public Role getById(Long idCustomer) {
        return null;
    }
}
