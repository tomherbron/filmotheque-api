package fr.eni.filmothequeapi.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends Person implements UserDetails {

    @Column(name = "user_name", length = 255, nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Rating> ratings = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_fk"),
            inverseJoinColumns = @JoinColumn(name = "role_fk"))
    private List<Role> roles = new ArrayList<>();

    public User(long id, String lastName, String firstName, String username, String email, String password,
                List<Rating> ratings, List<Role> roles) {
        super(id, lastName, firstName);
        this.username = username;
        this.email = email;
        this.password = password;
        this.ratings = ratings;
        this.roles = roles;
    }

    public User(String lastName, String firstName, String username, String email, String password,
                List<Rating> ratings, List<Role> roles) {
        super(lastName, firstName);
        this.username = username;
        this.email = email;
        this.password = password;
        this.ratings = ratings;
        this.roles = roles;
    }

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public String toString() {
        return "User{" +
                "userName='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ratings=" + ratings +
                ", roles=" + roles +
                '}';
    }
}
