package pe.com.consult.security.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.consult.security.persistence.entity.security.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findAllById(Long idCustomer);

    Role getById(Long idCustomer);
}