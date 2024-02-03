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
@Table( name = "OPERATIONS")
public class Operation {

    @Id
    @Column( name = "id_operation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column( name = "code_operation")
    private String codeOperation;
    @Column( name = "name_operation")
    private String name;
    @Column( name = "path_operation")
    private String path;
    @Column( name = "http_method_operation")
    private String httpMethod;
    @Column( name = "permit_all_operation")
    private boolean permitAll;

    @ManyToOne
    @JoinColumn( name = "id_submodule", nullable = false, foreignKey = @ForeignKey( name = "FK_SubmoduleID_Operation") )
    private SubModule subModule;
}
