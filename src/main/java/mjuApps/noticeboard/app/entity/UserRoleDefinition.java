package mjuApps.noticeboard.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_roles_dictionary")
public class UserRoleDefinition {

    @Id
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private UserRoleEnum userRoleEnum;

    public UserRoleDefinition() {}

    public UserRoleDefinition(Integer id, UserRoleEnum userRoleEnum) {
        this.id = id;
        this.userRoleEnum = userRoleEnum;
    }

    public Integer getId() {
        return id;
    }

    public UserRoleEnum getUserRoleEnum() {
        return userRoleEnum;
    }

    @Override
    public String toString() {
        return userRoleEnum.name();
    }
}
