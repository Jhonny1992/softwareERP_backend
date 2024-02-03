package pe.com.consult.security.persistence.entity.security;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table( name = "USERS_ROLES" )
public class RoleUser implements Serializable {

    @EmbeddedId
    private RoleUserPK roleUserPK;

    @ManyToOne
    @JoinColumn(name = "id_role", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey( name = "FK_RoleID_Roleusers"))
    private Role role;

    @ManyToOne
    @MapsId("userId")
    @ToString.Exclude
    @JoinColumn(name = "id_user", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey( name = "FK_UserID_Roleusers"))
    private User user;

}
