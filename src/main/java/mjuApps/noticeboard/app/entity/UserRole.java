package mjuApps.noticeboard.app.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_roles")
@NamedQueries(
        @NamedQuery(name = "rolesByUserId", query = "FROM UserRole ur WHERE ur.id=:userId")
)
public class UserRole implements Serializable {

    @Id
    @Column(name = "user_id")
    private Integer id;

    @Id
    @Column(name = "user_role_id")
    private Integer roleId;

    public UserRole() {}

    public UserRole(Integer id, Integer roleId) {
        this.id = id;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    @Override
    public String toString() {
        return "[" + id + ", " + roleId + "]";
    }
}
