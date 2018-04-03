package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.entity.User;
import mjuApps.noticeboard.app.exceptions.DatabaseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoHibernateImplTest {

    UserDao userDao;

    @Before
    public void setUp() {
        userDao = new UserDaoHibernateImpl();
    }

    @Test
    public void shouldGetUserByIdWhenExistsInDB() throws DatabaseException {
        Integer id = 1;
        User user = userDao.getById(id);

        Assert.assertTrue("User shouldn't be null", user!=null);
    }

}