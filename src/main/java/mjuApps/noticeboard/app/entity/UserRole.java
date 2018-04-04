package mjuApps.noticeboard.app.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_roles")
@NamedQueries(
        @NamedQuery(name = "rolesByUserId", query = "FROM UserRole ur WHERE ur.id=:userId")
)
public class UserRole implements Serializable {

    @Id
    @Column(name = "user_id")
    private Integer id;

    //  @Id
    //  @Column(name = "user_role_id")
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<UserRoleDefinition> userRoleDefinition;

    public UserRole() {}

    public UserRole(Integer id, List<UserRoleDefinition> userRoleDefinition) {
        this.id = id;
        this.userRoleDefinition = userRoleDefinition;
    }

    public Integer getId() {
        return id;
    }

    public List<UserRoleDefinition> getRoleId() {
        return userRoleDefinition;
    }

    @Override
    public String toString() {
        return "[" + id + ", " + userRoleDefinition.toString() + "]";
    }
}
