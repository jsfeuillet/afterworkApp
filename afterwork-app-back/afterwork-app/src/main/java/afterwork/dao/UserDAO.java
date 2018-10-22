package afterwork.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import afterwork.controller.model.User;
import afterwork.dao.interfaces.IUserDAO;

@Service
public class UserDAO implements IUserDAO {

	private static final String SQL = "INSERT INTO USERS(ID, NAME, USERNAME, MAIL) VALUES (USERS_SEQ.NEXTVAL, ?, ?, ?)";
	private static final String SELECT_FROM_USERS_WHERE_MAIL = "SELECT *FROM USERS WHERE MAIL = ?";

	public void insertUser(User user) {
		try {
			Connection connection = getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(SQL);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getUsername());
			prepareStatement.setString(3, user.getMail());
			
			prepareStatement.executeUpdate();
			prepareStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	}

	public User getUserByMail(String mail) {
		Connection connection;
		User userWithMail = null;

		try {
			connection = getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(SELECT_FROM_USERS_WHERE_MAIL);
			prepareStatement.setString(1, mail);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				userWithMail = new User();
				userWithMail.setName(resultSet.getString("NAME"));
				userWithMail.setUsername(resultSet.getString("USERNAME"));
				userWithMail.setMail(resultSet.getString("MAIL"));
			}
			prepareStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userWithMail;
	}

}
