package fr.eni.filmothequeapi.model.classes;

import com.fasterxml.jackson.annotation.*;
import fr.eni.filmothequeapi.model.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

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

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_fk"),
            inverseJoinColumns = @JoinColumn(name = "role_fk"))
    private List<Role> roles = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Rating> ratings = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "users_liked_movies", joinColumns = @JoinColumn(name = "user_fk"))
    @Column(name = "movie_fk")
    private Set<Long> likedMovies = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "users_disliked_movies", joinColumns = @JoinColumn(name = "user_fk"))
    @Column(name = "movie_fk")
    private Set<Long> dislikedMovies = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "users_favourite_genres", joinColumns = @JoinColumn(name = "user_fk"))
    @Column(name = "genre")
    private Set<Genre> favouriteGenres = new HashSet<>();

    public User(long id, String lastName, String firstName, String username, String email, String password, String gender,
                List<Rating> ratings, Set<Long> likedMovies, Set<Long> dislikedMovies, Set<Genre> favouriteGenres, List<Role> roles) {
        super(id, lastName, firstName);
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.ratings = ratings;
        this.likedMovies = likedMovies;
        this.dislikedMovies = dislikedMovies;
        this.favouriteGenres = favouriteGenres;
        this.roles = roles;
    }

    public User(String lastName, String firstName, String username, String email, String password, String gender,
                List<Rating> ratings, Set<Long> likedMovies, Set<Long> dislikedMovies, Set<Genre> favouriteGenres, List<Role> roles) {
        super(lastName, firstName);
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.ratings = ratings;
        this.likedMovies = likedMovies;
        this.favouriteGenres = favouriteGenres;
        this.dislikedMovies = dislikedMovies;
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
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", ratings=" + ratings +
                ", likedMovies=" + likedMovies +
                ", favouriteGenres=" + favouriteGenres +
                ", roles=" + roles +
                '}';
    }
}
