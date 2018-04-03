package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.entity.User;
import mjuApps.noticeboard.app.exceptions.DatabaseException;

public interface UserDao {

    User getById(Integer id) throws DatabaseException;

}
