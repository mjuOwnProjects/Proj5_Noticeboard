package mjuApps.noticeboard.app.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@NamedQueries(
        @NamedQuery(name="userWithRoles", query = " from User u left join fetch u.userRolesList where u.id=:id")
)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;

    @Column(name = "visible_name")
    private String visibleName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status_id")
    private StatusEnum statusEnum;

    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRolesEnum> userRolesList;

    public User() {
    }

    public User(String login, String visibleName, String firstName, String lastName, String email, String password, StatusEnum statusEnum, List<UserRolesEnum> userRolesList) {
        this.login = login;
        this.visibleName = visibleName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.statusEnum = statusEnum;
        this.userRolesList = userRolesList;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getVisibleName() {
        return visibleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public List<UserRolesEnum> getUserRolesList() {
        return userRolesList;
    }
}
