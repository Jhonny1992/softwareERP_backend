package pe.com.consult.security.persistence.entity.security;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PerfilRolePK implements Serializable {

    @Column( name = "id_module")
    private long subModuleId;
    @Column( name = "id_submodule")
    private long moduleId;
    @Column( name = "id_role")
    private long roleId;


}
