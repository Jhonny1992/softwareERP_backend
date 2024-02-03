package pe.com.consult.security.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RequestUser implements Serializable {

    @Size(min  = 5)
    private String firstname;
    @Size(min  = 5)
    private String lastname;
    @Size(min  = 5)
    private String username;
    @Size(min  = 8)
    private String password;
    @Size(min  = 8)
    private String repeatPassword;


}
