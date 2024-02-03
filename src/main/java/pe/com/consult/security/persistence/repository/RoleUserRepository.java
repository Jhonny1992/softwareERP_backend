package pe.com.consult.security.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.consult.security.persistence.entity.security.RoleUser;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
}
