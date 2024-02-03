package pe.com.consult.security.persistence.entity.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @Column(name = "id_company")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "code_company")
    private String codeCompany;
    @Column(name = "name_comapny")
    private String name;
    @Column(name = "ruc_company")
    private String ruc;
    @Column(name = "address_company")
    private String adress;
    @Column(name = "email_company")
    private String email;
    @Column(name = "status_company")
    private boolean status;
    @OneToMany(mappedBy = "company")
    private List<Branches> branches;

}
