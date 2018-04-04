package mjuApps.noticeboard.app.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "status_id")
    private UserStatus userStatus;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<UserRole> userRolesList;

    public User() {}

    public User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.login = userBuilder.login;
        this.visibleName = userBuilder.visibleName;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.userStatus = userBuilder.userStatus;
        this.userRolesList = userBuilder.userRolesList;
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
    public UserStatus getUserStatus() { return userStatus; }
    public List<UserRole> getUserRolesList() { return userRolesList; }

    public static class UserBuilder {
        private Integer id;
        private String login;
        private String visibleName;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private UserStatus userStatus;
        private List<UserRole> userRolesList;

        public UserBuilder() {}

        public UserBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public UserBuilder withLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder withVisibleName(String visibleName) {
            this.visibleName = visibleName;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withUserStatus(UserStatus userStatus) {
            this.userStatus = userStatus;
            return this;
        }

        public UserBuilder withUserRolesList(List<UserRole> userRolesList) {
            this.userRolesList = userRolesList;
            return this;
        }

        public User buildUser() {
            return new User(this);
        }

    }
}
