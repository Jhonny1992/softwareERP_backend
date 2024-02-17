package pe.com.consult.security.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.consult.security.persistence.entity.security.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);
    User findTopByOrderByIdDesc();

    @Query(value = "SELECT r.name_role FROM users u " +
                                        " INNER JOIN users_roles ur on u.id_user = ur.id_user " +
                                        " INNER JOIN roles r on r.id_role = ur.id_role " +
                                        " WHERE u.id_user=:userId",
            nativeQuery = true)
    List<String> findRoleNamesByUserId(Long userId);

}
