package mjuApps.noticeboard.app.dao.AssertObject;

import mjuApps.noticeboard.app.entity.UserStatus;
import mjuApps.noticeboard.app.entity.UserStatusEnum;
import org.junit.Assert;

public class UserStatusDaoAssert {

    private UserStatus userStatus;

    public UserStatusDaoAssert(UserStatus actualUserStatus) {
        this.userStatus = actualUserStatus;
    }

    public UserStatusDaoAssert hasId(Integer expectedId) {
        Assert.assertEquals("Id should be " + expectedId,expectedId,userStatus.getId());
        return this;
    }

    public UserStatusDaoAssert hasStatusEnum(UserStatusEnum expectedUserStatusEnum) {
        Assert.assertEquals("Expected status ENUM should be " + expectedUserStatusEnum, expectedUserStatusEnum, userStatus.getUserStatusEnum());
        return this;
    }
}
