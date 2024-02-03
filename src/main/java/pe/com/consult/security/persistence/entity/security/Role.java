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
@Table( name = "ROLES")
public class Role {

    @Id
    @Column( name = "id_role")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    @Column( name = "code_role")
    private String codeRole;
    @Column( name = "name_role")
    private String name;
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<GrantedPermission> permissions;

}
