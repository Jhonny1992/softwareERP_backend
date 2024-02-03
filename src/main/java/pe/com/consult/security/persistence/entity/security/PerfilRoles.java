package pe.com.consult.security.persistence.entity.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table( name = "PERFILES_ROLES")
public class PerfilRoles implements Serializable {

    @EmbeddedId
    private PerfilRolePK perfilRolePK;

    @ManyToOne
    @JoinColumn(name = "id_module", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey( name = "FK_ModuleID"))
    private Module module;

    @ManyToOne
    @JoinColumn(name = "id_submodule", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey( name = "FK_SubmoduleID"))
    private SubModule subModule;

    @ManyToOne
    @JoinColumn(name = "id_role", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey( name = "FK_RoleID"))
    private Role role;
}
