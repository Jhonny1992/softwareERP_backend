package pe.com.consult.security.persistence.entity;

import jakarta.persistence.*;
import pe.com.consult.security.persistence.entity.security.Company;

import java.math.BigDecimal;

@Entity
@Table( name = "PRICES")
public class Price {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_price")
    private long id;
    @Column( name = "code_price")
    private String code_price;
    @Column( name = "price")
    private BigDecimal price;
    @Column( name = "status_price")
    private boolean status;
    @ManyToOne//FK
    @JoinColumn( name = "id_product", nullable = false, foreignKey = @ForeignKey( name = "FK_id_product_prices"))
    private Product product;
    @ManyToOne//FK
    @JoinColumn( name = "id_company", nullable = false, foreignKey = @ForeignKey( name = "FK_id_company_prices"))
    private Company company;

}
