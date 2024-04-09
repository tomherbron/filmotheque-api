package fr.eni.filmothequeapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Person implements UserDetails {
    @Column(name = "user_name", length = 255, nullable = false, unique = true)
    private String userName;
    @Column(name = "password", length = 255)
    private String password;
    @Column(name = "is_admin")
    private boolean isAdmin;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Rating> ratings = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_fk"),
            inverseJoinColumns = @JoinColumn(name = "role_fk"))
    private List<Role> roles = new ArrayList<>();

    public User(long id, String lastName, String firstName, String userName, String password, boolean isAdmin,
                List<Rating> ratings, List<Role> roles) {
        super(id, lastName, firstName);
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.ratings = ratings;
        this.roles = roles;
    }

    public User(String lastName, String firstName, String userName, String password, boolean isAdmin,
                List<Rating> ratings, List<Role> roles) {
        super(lastName, firstName);
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.ratings = ratings;
        this.roles = roles;
    }

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", ratings=" + ratings +
                ", roles=" + roles +
                '}';
    }
}
