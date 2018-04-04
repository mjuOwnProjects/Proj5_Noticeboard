package mjuApps.noticeboard.app.dao.AssertObject;

import mjuApps.noticeboard.app.entity.User;
import mjuApps.noticeboard.app.entity.UserStatus;
import mjuApps.noticeboard.app.entity.UserStatusEnum;
import org.junit.Assert;

public class UserDaoAssert {

    private User user;

    //todo - userRolesList

    public UserDaoAssert(User actualUser) {
        this.user = actualUser;
    }

    public UserDaoAssert hasId(Integer expectedId) {
        Assert.assertEquals("Id should be " + expectedId, expectedId, user.getId());
        return this;
    }

    public UserDaoAssert hasLogin(String expectedLogin) {
        Assert.assertEquals("Login should be " + expectedLogin, expectedLogin, user.getLogin());
        return this;
    }

    public UserDaoAssert hasFirstname(String expectedFirstname) {
        Assert.assertEquals("Firstname should be " + expectedFirstname, expectedFirstname, user.getFirstName());
        return this;
    }

    public UserDaoAssert hasLastname(String expectedLastname) {
        Assert.assertEquals("Lastname should be " + expectedLastname, expectedLastname, user.getLastName());
        return this;
    }

    public UserDaoAssert hasVisibleName(String expectedVisibleName) {
        Assert.assertEquals("Visible Name should be " + expectedVisibleName, expectedVisibleName, user.getVisibleName());
        return this;
    }

    public UserDaoAssert hasPassword(String expectedPassword) {
        Assert.assertEquals("Password should be " + expectedPassword, expectedPassword, user.getPassword());
        return this;
    }

    public UserDaoAssert hasEmail(String expectedEmail) {
        Assert.assertEquals("Email should be " + expectedEmail, expectedEmail, user.getEmail());
        return this;
    }

    public UserDaoAssert hasStatus(UserStatus expectedUserStatus) {
        Integer expectedStatusId = expectedUserStatus.getId();
        Integer actualStatusId = user.getId();
        Assert.assertEquals("User status id should be " + expectedStatusId, expectedStatusId, actualStatusId);

        UserStatusEnum expectedStatusEnum = expectedUserStatus.getUserStatusEnum();
        UserStatusEnum actualStatusEnum = user.getUserStatus().getUserStatusEnum();
        Assert.assertEquals("User status ENUM should be " + expectedStatusEnum, expectedStatusEnum, actualStatusEnum);
        return this;
    }

}
