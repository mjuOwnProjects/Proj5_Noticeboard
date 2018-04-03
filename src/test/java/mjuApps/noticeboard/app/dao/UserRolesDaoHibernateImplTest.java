package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.entity.User;
import mjuApps.noticeboard.app.entity.UserRoles;
import mjuApps.noticeboard.app.exceptions.DatabaseException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRolesDaoHibernateImplTest {

    UserRolesDao userRolesDao ;
    UserDao userDao;

    @Before
    public void setUp() {
        userDao = new UserDaoHibernateImpl();
        userRolesDao = new UserRolesDaoHibernateImpl();
    }

    @Test
    public void shouldGetUserRolesWhenUserExist() throws DatabaseException {
        User user = userDao.getById(1);
        User userWithRoles = userRolesDao.getRolesByUser(user);
    }

}