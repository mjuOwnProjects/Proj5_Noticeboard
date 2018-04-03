package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.entity.User;
import mjuApps.noticeboard.app.exceptions.DatabaseException;
import mjuApps.noticeboard.app.utils.HibernateConfigurationLoader;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    private SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public User getById(Integer id) throws DatabaseException {
        Session session;
        User user;
        try {
            session = sessionFactory.openSession();
            user = session.find(User.class,id);
            session.close();
        } catch (HibernateException ex) {
            throw new DatabaseException("Error while getting user with id " + id);
        }
        return user;
    }
}
