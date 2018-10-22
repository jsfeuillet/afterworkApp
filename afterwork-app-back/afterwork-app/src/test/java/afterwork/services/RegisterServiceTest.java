package afterwork.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import afterwork.controller.model.User;
import afterwork.dao.UserDAO;
import afterwork.dao.interfaces.IUserDAO;
import afterwork.dto.InfoDTO;

public class RegisterServiceTest {

	private static final String OK_INFO = "OK";
	private static final String NOK_MAIL_EXISTS = "NOK_MAIL";
	private static final String NOK_MAIL_INCORRECT = "NOK_MAIL_BAD";
	private static final String NOK_USERNAME_INCORRECT = "NOK_USER_BAD";

	@Test
	public void shuldInsertANewUserUsingTheUserDAO() {
		//ARRANGE
		RegisterService serviceSUT = new RegisterService();		
		User user = new User();
		user.setMail("mail@mail.com");
		user.setUsername("usu1");
		
		IUserDAO userDAO = mock(UserDAO.class);
		serviceSUT.setUserDAO(userDAO);
		
		//ACT
		serviceSUT.registerUser(user);
		
		//ASSERT
		verify(userDAO, times(1)).insertUser(user);
	}
	
	@Test
	public void shouldReturnCorrectTypeInfoAfterInsertUser() {
		//ARRANGE
		RegisterService serviceSUT = new RegisterService();		
		User user = new User();
		user.setMail("mail@mail.com");
		user.setUsername("usu1");
		
		IUserDAO userDAO = mock(UserDAO.class);
		serviceSUT.setUserDAO(userDAO);
		
		//ACT
		InfoDTO userDTO = serviceSUT.registerUser(user);
		
		//ASSERT
		assertThat(userDTO.getInfo(), equalTo(OK_INFO));
	}
	
	@Test
	public void ifAUserWithMailNotExistsThenInsert() {
		//ARRANGE
		RegisterService serviceSUT = new RegisterService();		
		User user = new User();
		user.setMail("mail@mail.com");
		user.setUsername("usu1");

		IUserDAO userDAO = mock(UserDAO.class);
		serviceSUT.setUserDAO(userDAO);
		
		doReturn(null).when(userDAO).getUserByMail(user.getMail());
		
		//ACT
		InfoDTO userDTO = serviceSUT.registerUser(user);
		
		//ASSERT
		assertThat(userDTO.getInfo(), equalTo(OK_INFO));
	}
	
	@Test
	public void ifAUserWithMailAlreadyExistsThenReturnErrorMesage() {
		//ARRANGE
		RegisterService serviceSUT = new RegisterService();		
		User user = new User();
		user.setMail("mail@mail.com");
		user.setUsername("usu1");
		
		IUserDAO userDAO = mock(UserDAO.class);
		serviceSUT.setUserDAO(userDAO);
		
		User userAlreadyExistent = new User();
		doReturn(userAlreadyExistent ).when(userDAO).getUserByMail(user.getMail());
		
		//ACT
		InfoDTO userDTO = serviceSUT.registerUser(user);
		
		//ASSERT
		assertThat(userDTO.getInfo(), equalTo(NOK_MAIL_EXISTS));
	}
	
	@Test
	public void ifMailIsNotCorrectThenReturnErrorMessage() {
		//ARRANGE
		RegisterService serviceSUT = new RegisterService();		
		User user = new User();
		user.setMail("mail_incorrecto");
		IUserDAO userDAO = mock(UserDAO.class);
		serviceSUT.setUserDAO(userDAO);
		
		//ACT
		InfoDTO userDTO = serviceSUT.registerUser(user);
		
		//ASSERT
		assertThat(userDTO.getInfo(), equalTo(NOK_MAIL_INCORRECT));
	}
	
	@Test
	public void ifUsernameIsNotCorrectThenReturnErrorMessage() {
		//ARRANGE
		RegisterService serviceSUT = new RegisterService();		
		User user = new User();
		user.setMail("mail@mail.com");
		user.setUsername("el usuário");

		IUserDAO userDAO = mock(UserDAO.class);
		serviceSUT.setUserDAO(userDAO);
		
		//ACT
		InfoDTO userDTO = serviceSUT.registerUser(user);
		
		//ASSERT
		assertThat(userDTO.getInfo(), equalTo(NOK_USERNAME_INCORRECT));
	}

}
