package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.dao.AssertObject.UserDaoAssert;
import mjuApps.noticeboard.app.entity.User;
import mjuApps.noticeboard.app.exceptions.DatabaseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserDaoHibernateImplTest {

    UserDao userDao;
    UserDaoAssert userDaoAssert;

    @Before
    public void setUp() {
        userDao = new UserDaoHibernateImpl();
    }

    @Test
    public void shouldGetUserByIdWhenExistsInDB() throws DatabaseException {

        User testUser = new User.UserBuilder()
                .withId(1)
                .withLogin("test")
                .withFirstName("Jan")
                .withLastName("Kowalski")
                .withVisibleName("Użytkownik Testowy")
                .withEmail("mjuApps@gmail.com")
                .withPassword("Test@123")
//                .withUserStatus()
                .buildUser();

        Integer id = 1;
        User user = userDao.getById(id);

        Assert.assertTrue("User shouldn't be null", user!=null);
        userDaoAssert = new UserDaoAssert(user);
        userDaoAssert
                .hasId(testUser.getId())
                .hasLogin(testUser.getLogin())
                .hasFirstname(testUser.getFirstName())
                .hasLastname(testUser.getLastName())
                .hasVisibleName(testUser.getVisibleName())
                .hasEmail(testUser.getEmail())
                .hasPassword(testUser.getPassword());

    }

}