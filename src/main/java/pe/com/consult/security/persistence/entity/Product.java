package pe.com.consult.security.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table( name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id_product")
    private Long id;
    @Column( name = "name_product")
    private String name;
    @Column( name = "description_product")
    private String description;
    @Column( name = "price_product")
    private BigDecimal price;
}
