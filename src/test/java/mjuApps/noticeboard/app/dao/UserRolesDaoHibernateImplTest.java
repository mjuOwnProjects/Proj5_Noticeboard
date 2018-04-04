package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.entity.User;
import mjuApps.noticeboard.app.entity.UserRole;
import mjuApps.noticeboard.app.exceptions.DatabaseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;


public class UserRolesDaoHibernateImplTest {

    UserRolesDao userRolesDao;

    @Before
    public void setup() {
        userRolesDao = new UserRolesDaoHibernateImpl();
    }

    @Test
    public void shouldGetUserRolesForExistingUser() throws DatabaseException {
        List<UserRole> userRoles = userRolesDao.getUserRolesByUserId(2);
        Assert.assertEquals("List size should be 2", 2, userRoles.size());
    }

    @Test
    public void shouldGetUserRolesByGetterInUserClass() throws DatabaseException {
        UserDao userDao = new UserDaoHibernateImpl();
        User user = userDao.getById(2);
        List<UserRole> userRoles = user.getUserRolesList();
        Assert.assertEquals("List size should be 2", 2, userRoles.size());
    }

}