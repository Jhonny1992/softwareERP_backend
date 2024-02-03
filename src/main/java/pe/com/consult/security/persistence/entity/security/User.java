package pe.com.consult.security.persistence.entity.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "USERS")
public class User implements UserDetails {

    @Id
    @Column( name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column( name = "code_user")
    private String codeUser;
    @Column( name = "name_user", unique = true)
    private String userName;
    @Column( name = "first_name")
    private String firstName;
    @Column( name = "second_name")
    private String second_name;
    @Column( name = "last_name_first")
    private String lastNameFirst;
    @Column( name = "last_name_second")
    private String lastNameSecond;
    @Column( name = "password_user")
    private String password;
    @Column( name = "status_user")
    private boolean userStatus;
    @ManyToOne//FK
    @JoinColumn( name = "id_branch", nullable = false, foreignKey = @ForeignKey( name = "FK_SucursalID") )
    private Branches branches;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoleUser> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(roles ==  null ) return null;

        List<SimpleGrantedAuthority> authorities = roles.stream()
                .map(roleUser -> roleUser.getRole().getPermissions())
                .flatMap(List::stream)
                .map(permission -> new SimpleGrantedAuthority(permission.getOperation().getName()))
                .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.roles.get(0).getRole().getName()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
