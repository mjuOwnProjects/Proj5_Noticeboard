package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.entity.User;
import mjuApps.noticeboard.app.entity.UserRoles;
import mjuApps.noticeboard.app.exceptions.DatabaseException;

public interface UserRolesDao {

    User getRolesByUser(User user) throws DatabaseException;

}
