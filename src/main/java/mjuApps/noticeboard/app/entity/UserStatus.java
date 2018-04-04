package mjuApps.noticeboard.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "status_dictionary")
@NamedQueries(
        @NamedQuery(name = "getStatusByStatusName", query = "FROM UserStatus us WHERE us.userStatusEnum LIKE :searchedStatus")
)
public class UserStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private UserStatusEnum userStatusEnum;

    public UserStatus() {}

    public UserStatus(UserStatusBuilder userStatusBuilder) {
        this.id = userStatusBuilder.id;
        this.userStatusEnum = userStatusBuilder.userStatusEnum;
    }

    public UserStatus(UserStatusEnum userStatusEnum) {
        this.userStatusEnum = userStatusEnum;
    }

    public Integer getId() {
        return id;
    }

    public UserStatusEnum getUserStatusEnum() {
        return userStatusEnum;
    }

    public static class UserStatusBuilder {

        private Integer id;
        private UserStatusEnum userStatusEnum;

        public UserStatusBuilder() {};

        public UserStatusBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public UserStatusBuilder withUserStatusEnum(UserStatusEnum userStatusEnum) {
            this.userStatusEnum = userStatusEnum;
            return this;
        }

        public UserStatusBuilder withUserStatusEnumAsString(String userStatusEnumName) {
            this.userStatusEnum = UserStatusEnum.valueOf(userStatusEnumName);
            return this;
        }

        public UserStatus build() {
            return new UserStatus(this);
        }
    }
}
