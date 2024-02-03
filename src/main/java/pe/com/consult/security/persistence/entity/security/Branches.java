package pe.com.consult.security.persistence.entity.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "BRANCHES")
public class Branches {

    @Id
    @Column( name = "id_branches")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column( name = "code_branch")
    private String codeBranches;
    @Column( name = "address_branch")
    private String adress;
    @Column( name = "phone_branch")
    private String phone;
    @ManyToOne//FK
    @JoinColumn( name = "id_company", nullable = false, foreignKey = @ForeignKey( name = "FK_BusinessID"))
    private Company company;
}
