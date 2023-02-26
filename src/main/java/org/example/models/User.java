package org.example.models;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String firstName, String secondName, String username, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    // Without the setter it will show  .PropertyValueException:  not-null property references a null or transient value : org.example.models.User.firstName, but it seems other properties dont matter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    public void setSecondName(String secondName) {
//        this.secondName = secondName;
//    }

//    public void setUsername(String username) {
//        this.username = username;
//    }

//    public void setPassword(String password) {
//        this.password = password;
//    }
}
