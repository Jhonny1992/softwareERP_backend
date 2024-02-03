package pe.com.consult.security.persistence.entity.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "SUBMODULES")
public class SubModule {

    @Id
    @Column(name = "id_submodule")
    private long id;
    @Column(name = "name_submodule")
    private String name;
    @Column(name = "base_path_submodule")
    private String basePath;
}
