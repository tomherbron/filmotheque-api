package fr.eni.filmothequeapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Person {
    @Column(name = "user_name", length = 255)
    private String userName;
    @Column(name = "password", length = 255)
    private String password;
    @Column(name = "is_admin")
    private boolean isAdmin;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Rating> ratings = new ArrayList<>();

    public User(long id, String lastName, String firstName, String userName, String password, boolean isAdmin,
                List<Rating> ratings) {
        super(id, lastName, firstName);
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.ratings = ratings;
    }

    public User(String lastName, String firstName, String userName, String password, boolean isAdmin,
                List<Rating> ratings) {
        super(lastName, firstName);
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.ratings = ratings;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
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

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", ratings=" + ratings +
                '}';
    }
}