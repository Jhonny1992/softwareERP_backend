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
@Table( name = "GRANTED_PERMISSIONS")
public class GrantedPermission {

    @Id
    @Column( name = "id_granted_permission")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false, foreignKey = @ForeignKey( name = "FK_RoleID_GrantedPermission"))
    private Role role;
    @ManyToOne
    @JoinColumn(name = "id_operation", nullable = false, foreignKey = @ForeignKey( name = "FK_OperationID_GrantedPermission"))
    private Operation operation;
}
