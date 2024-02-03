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
@Table(name = "MODULES")
public class Module {

    @Id
    @Column(name = "id_module")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "code_module")
    private String codeModule;
    @Column(name = "name_module")
    private String name;
    @Column(name = "base_path_module")
    private String BasePath;
}
