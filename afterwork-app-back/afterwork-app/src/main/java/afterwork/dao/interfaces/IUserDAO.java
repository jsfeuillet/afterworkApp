package afterwork.dao.interfaces;

import afterwork.controller.model.User;

public interface IUserDAO {

	void insertUser(User user);

	User getUserByMail(String mail);

}
