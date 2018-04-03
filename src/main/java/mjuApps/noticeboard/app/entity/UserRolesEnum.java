package mjuApps.noticeboard.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_roles_dictionary")
public enum UserRolesEnum {

    ADMIN(1),REGULAR_USER(2);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    UserRolesEnum(Integer id) {
        this.roleId = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

}
