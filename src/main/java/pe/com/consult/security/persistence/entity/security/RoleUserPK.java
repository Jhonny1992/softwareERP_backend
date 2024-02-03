package pe.com.consult.security.persistence.entity.security;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Embeddable
public class RoleUserPK implements Serializable {

    @Column( name = "id_user")
    private long userId;

    @Column( name = "id_role")
    private long roleId;

}
