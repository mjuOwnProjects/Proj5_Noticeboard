package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.entity.UserRole;
import mjuApps.noticeboard.app.exceptions.DatabaseException;
import mjuApps.noticeboard.app.utils.HibernateConfigurationLoader;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import java.util.List;

public class UserRolesDaoHibernateImpl implements UserRolesDao {

    private SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public List<UserRole> getUserRolesByUserId(Integer id) throws DatabaseException {
        Session session = null;
        List<UserRole> userRoles = null;
        try {
            session = sessionFactory.openSession();
            Query<UserRole> query = session.createNamedQuery("rolesByUserId",UserRole.class);
            query.setParameter("userId",id);
            userRoles = query.getResultList();
        } catch (HibernateException ex) {
            logger.error("Error while getting roles for user with id " + id, ex);
            throw new DatabaseException("Error while getting roles for user with id " + id, ex);
        } finally {
            session.close();
        }
        return userRoles;
    }
}
