package mjuApps.noticeboard.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_roles")
public class UserRoles implements Serializable{

    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRolesEnum userRolesEnum;

    public UserRoles() {
    }

    public UserRoles(User user, UserRolesEnum userRolesEnum) {
        this.user = user;
        this.userRolesEnum = userRolesEnum;
    }

    public User getUser() {
        return user;
    }

    public UserRolesEnum getUserRolesEnum() {
        return userRolesEnum;
    }
}
