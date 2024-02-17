package pe.com.consult.security.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.consult.security.persistence.entity.Product;
import pe.com.consult.security.persistence.entity.security.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findTopByOrderByIdDesc();
}
