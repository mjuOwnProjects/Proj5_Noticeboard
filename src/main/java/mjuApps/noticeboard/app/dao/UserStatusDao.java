package mjuApps.noticeboard.app.dao;

import mjuApps.noticeboard.app.entity.UserStatus;
import mjuApps.noticeboard.app.exceptions.DatabaseException;

public interface UserStatusDao {

    public UserStatus getStatusByName(String statusName) throws DatabaseException;

}
