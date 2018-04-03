package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.entity.User;
import mjuApps.noticeboard.app.entity.UserRoles;
import mjuApps.noticeboard.app.exceptions.DatabaseException;
import mjuApps.noticeboard.app.utils.HibernateConfigurationLoader;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UserRolesDaoHibernateImpl implements UserRolesDao {

    private SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public User getRolesByUser(User user) throws DatabaseException {
        Session session = null;
        Integer id = user.getId();
        try {
            session = sessionFactory.openSession();
            Query<User> orderQuery = session.createNamedQuery("userWithRoles",User.class);
            orderQuery.setParameter("id", id);
            return orderQuery.getSingleResult();
        } catch (HibernateException e) {
            logger.error("Error while finding roles for User with id = " + id, e);
            throw new DatabaseException("Error while finding roles for User with id = " + id, e);
        } finally {
            session.close();
        }
    }
}
