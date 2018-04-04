package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.entity.UserStatus;
import mjuApps.noticeboard.app.entity.UserStatusEnum;
import mjuApps.noticeboard.app.exceptions.DatabaseException;
import mjuApps.noticeboard.app.utils.HibernateConfigurationLoader;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UserStatusHibernateImpl implements UserStatusDao {

    private SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public UserStatus getStatusByName(String statusName) throws DatabaseException {
        Session session = null;
        UserStatus userStatus = null;
        UserStatusEnum searchedEnum = UserStatusEnum.valueOf(statusName);
        try {
            session = sessionFactory.openSession();
            Query<UserStatus> query = session.createNamedQuery("getStatusByStatusName",UserStatus.class);
            query.setParameter("searchedStatus",UserStatusEnum.valueOf(statusName));
            userStatus = query.getSingleResult();
        } catch (HibernateException ex) {
            logger.error("Error while getting status by name " + statusName, ex);
            throw new DatabaseException("Error while getting status by name " + statusName, ex);
        } finally {
            session.close();
        }
        return userStatus;
    }
}
