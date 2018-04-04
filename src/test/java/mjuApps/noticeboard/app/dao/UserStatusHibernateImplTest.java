package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.dao.AssertObject.UserStatusDaoAssert;
import mjuApps.noticeboard.app.entity.UserStatus;
import mjuApps.noticeboard.app.entity.UserStatusEnum;
import mjuApps.noticeboard.app.exceptions.DatabaseException;
import org.junit.Before;
import org.junit.Test;


public class UserStatusHibernateImplTest {

    UserStatusDao userStatusDao;

    @Before
    public void setup() {
        userStatusDao = new UserStatusHibernateImpl();
    }

    @Test
    public void shouldGetUserStatusWhenExist() throws DatabaseException {
        String givenStatusName = "ACTIVE";
        UserStatus expectedUserStatus = new UserStatus.UserStatusBuilder()
                                                .withId(1)
                                                .withUserStatusEnumAsString(givenStatusName)
                                                .build();
        UserStatus actualUserStatus = userStatusDao.getStatusByName(givenStatusName);

        UserStatusDaoAssert userStatusDaoAssert = new UserStatusDaoAssert(actualUserStatus);
        userStatusDaoAssert
                .hasId(expectedUserStatus.getId())
                .hasStatusEnum(expectedUserStatus.getUserStatusEnum());
    }
}