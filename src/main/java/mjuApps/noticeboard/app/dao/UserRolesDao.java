package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.entity.UserRole;
import mjuApps.noticeboard.app.exceptions.DatabaseException;

import java.util.List;

public interface UserRolesDao {

    List<UserRole> getUserRolesByUserId(Integer id) throws DatabaseException;

}
