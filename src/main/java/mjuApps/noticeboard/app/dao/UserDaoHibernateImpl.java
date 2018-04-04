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
        Session session=null;
        User user=null;
        try {
            session = sessionFactory.openSession();
            user = session.get(User.class,id);
        } catch (HibernateException ex) {
            logger.error("Error while getting user with id " + id,ex);
            throw new DatabaseException("Error while getting user with id " + id);
        } finally {
            session.close();
        }
        return user;
    }
}
