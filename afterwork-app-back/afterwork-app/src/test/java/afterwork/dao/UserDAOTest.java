package afterwork.dao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.junit.Test;

import afterwork.controller.model.User;

public class UserDAOTest {

	private static final String SELECT_FROM_USERS_WHERE_MAIL = "SELECT *FROM USERS WHERE MAIL = ?";
	private static final String SQL = "INSERT INTO USERS(ID, NAME, USERNAME, MAIL) VALUES (USERS_SEQ.NEXTVAL, ?, ?, ?)";

	
	@Test
	public void shouldCallPrepareStatementWithQuery() throws SQLException {
		//ARRANGE
		UserDAO userDaoSUT = spy(new UserDAO());	
		User user = new User();
		Connection connection  = mock(Connection.class);
		doReturn(connection).when(userDaoSUT).getConnection();
		PreparedStatement prepareStatement = mock(PreparedStatement.class);
		doReturn(prepareStatement).when(connection).prepareStatement(SQL);
		
		//ACT
		userDaoSUT.insertUser(user);
		
		//ASSERT
		verify(connection, times(1)).prepareStatement(SQL);
	}
	
	@Test
	public void shouldSetInputParameters() throws SQLException {
		//ARRANGE
		UserDAO userDaoSUT = spy(new UserDAO());	
		User user = getAnyUser();
		
		Connection connection  = mock(Connection.class);
		doReturn(connection).when(userDaoSUT).getConnection();
		PreparedStatement prepareStatement = mock(PreparedStatement.class);
		doReturn(prepareStatement).when(connection).prepareStatement(SQL);
		
		//ACT
		userDaoSUT.insertUser(user);

		//ASSERT
		verify(prepareStatement, times(1)).setString(1, user.getName());
		verify(prepareStatement, times(1)).setString(2, user.getUsername());
		verify(prepareStatement, times(1)).setString(3, user.getMail());
	}

	@Test
	public void shouldCallExecuteUpdateAndCloses() throws SQLException {
		//ARRANGE
		UserDAO userDaoSUT = spy(new UserDAO());	
		User user = getAnyUser();
		
		Connection connection  = mock(Connection.class);
		doReturn(connection).when(userDaoSUT).getConnection();
		PreparedStatement prepareStatement = mock(PreparedStatement.class);
		doReturn(prepareStatement).when(connection).prepareStatement(SQL);
		
		//ACT
		userDaoSUT.insertUser(user);
		
		//ASSERT
		verify(prepareStatement, times(1)).executeUpdate();
		verify(prepareStatement, times(1)).close();
		verify(connection, times(1)).close();
	}
	
	@Test
	public void getUserByMailShouldCallPrepareStatementWithQuery() throws SQLException {
		//ARRANGE
		UserDAO userDaoSUT = spy(new UserDAO());	
		User user = getAnyUser();
		Connection connection  = mock(Connection.class);
		doReturn(connection).when(userDaoSUT).getConnection();
		PreparedStatement prepareStatement = mock(PreparedStatement.class);
		doReturn(prepareStatement).when(connection).prepareStatement(SELECT_FROM_USERS_WHERE_MAIL);
		ResultSet resultSet = mock(ResultSet.class);
		doReturn(resultSet).when(prepareStatement).executeQuery();
		
		//ACT
		userDaoSUT.getUserByMail(user.getMail());
		
		//ASSERT
		verify(connection, times(1)).prepareStatement(SELECT_FROM_USERS_WHERE_MAIL);
	}
	
	@Test
	public void getUserByMailshouldSetInputParameters() throws SQLException {
		//ARRANGE
		UserDAO userDaoSUT = spy(new UserDAO());	
		User user = getAnyUser();
		
		Connection connection  = mock(Connection.class);
		doReturn(connection).when(userDaoSUT).getConnection();
		PreparedStatement prepareStatement = mock(PreparedStatement.class);
		doReturn(prepareStatement).when(connection).prepareStatement(SELECT_FROM_USERS_WHERE_MAIL);
		ResultSet resultSet = mock(ResultSet.class);
		doReturn(resultSet).when(prepareStatement).executeQuery();
		
		//ACT
		userDaoSUT.getUserByMail(user.getMail());

		//ASSERT
		verify(prepareStatement, times(1)).setString(1, user.getMail());
	}
	
	@Test
	public void getUserByMailshouldCallExecuteQueryAndCloses() throws SQLException {
		//ARRANGE
		UserDAO userDaoSUT = spy(new UserDAO());	
		User user = getAnyUser();
		
		Connection connection  = mock(Connection.class);
		doReturn(connection).when(userDaoSUT).getConnection();
		PreparedStatement prepareStatement = mock(PreparedStatement.class);
		doReturn(prepareStatement).when(connection).prepareStatement(SELECT_FROM_USERS_WHERE_MAIL);
		ResultSet resultSet = mock(ResultSet.class);
		doReturn(resultSet).when(prepareStatement).executeQuery();
		
		//ACT
		userDaoSUT.getUserByMail(user.getMail());
		
		//ASSERT
		verify(prepareStatement, times(1)).executeQuery();
		verify(prepareStatement, times(1)).close();
		verify(connection, times(1)).close();
	}
	
	@Test
	public void getUserByMailshouldReturnObtainedUser() throws SQLException {
		//ARRANGE
		UserDAO userDaoSUT = spy(new UserDAO());	
		User user = getAnyUser();
		
		Connection connection  = mock(Connection.class);
		doReturn(connection).when(userDaoSUT).getConnection();
		PreparedStatement prepareStatement = mock(PreparedStatement.class);
		doReturn(prepareStatement).when(connection).prepareStatement(SELECT_FROM_USERS_WHERE_MAIL);
		
		ResultSet resultSet = mock(ResultSet.class);
		doReturn(resultSet).when(prepareStatement).executeQuery();
		doReturn(true).when(resultSet).next();
		
		User userFromDB = getAnyUser();
		doReturn(userFromDB.getName()).when(resultSet).getString("NAME");
		doReturn(userFromDB.getUsername()).when(resultSet).getString("USERNAME");
		doReturn(userFromDB.getMail()).when(resultSet).getString("MAIL");
		
		//ACT
		User userAlreadyExistent = userDaoSUT.getUserByMail(user.getMail());
		
		//ASSERT
		assertThat(userFromDB.getName(), equalTo(userAlreadyExistent.getName()));
		assertThat(userFromDB.getUsername(), equalTo(userAlreadyExistent.getUsername()));
		assertThat(userFromDB.getMail(), equalTo(userAlreadyExistent.getMail()));		
	}
	
	@Test
	public void getUserByMailshouldReturnNullIfNoUserFound() throws SQLException {
		//ARRANGE
		UserDAO userDaoSUT = spy(new UserDAO());	
		User user = getAnyUser();
		
		Connection connection  = mock(Connection.class);
		doReturn(connection).when(userDaoSUT).getConnection();
		PreparedStatement prepareStatement = mock(PreparedStatement.class);
		doReturn(prepareStatement).when(connection).prepareStatement(SELECT_FROM_USERS_WHERE_MAIL);
		
		ResultSet resultSet = mock(ResultSet.class);
		doReturn(resultSet).when(prepareStatement).executeQuery();
		doReturn(false).when(resultSet).next();
		
		
		//ACT
		User userAlreadyExistent = userDaoSUT.getUserByMail(user.getMail());
		
		//ASSERT
		assertThat(userAlreadyExistent, is(nullValue()));		
	}
	
	private User getAnyUser() {
		User user = new User();
		Random random = new Random();
		String name = String.valueOf(random.nextDouble());
		user.setName(name);
		String username = String.valueOf(random.nextDouble());
		user.setUsername(username);
		String mail = String.valueOf(random.nextDouble());
		user.setMail(mail);
		return user;
	}
}
