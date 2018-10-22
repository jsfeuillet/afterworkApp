package afterwork.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import afterwork.controller.model.User;
import afterwork.dto.InfoDTO;
import afterwork.services.RegisterService;
import afterwork.services.interfaces.IRegisterService;

public class RegisterControllerTest {

	@Test
	public void shuldCallServiceToRegisterANewUser() {
		//ARRANGE
		RegisterController controllerSUT = new RegisterController();
		IRegisterService registerService = mock(RegisterService.class);
		controllerSUT.setRegisterService(registerService);
		User user = new User();
		
		//ACT
		controllerSUT.registerUser(user);
		
		//ASSERT
		verify(registerService, times(1)).registerUser(user);
	}
	
	@Test
	public void shouldReturnADTOObjectWithRegisternformation() {
		//ARRANGE
		RegisterController controllerSUT = new RegisterController();
		IRegisterService registerService = mock(RegisterService.class);
		controllerSUT.setRegisterService(registerService);
		User user = new User();
		
		InfoDTO registeredUser = new InfoDTO();
		doReturn(registeredUser ).when(registerService).registerUser(user);
		
		//ACT
		InfoDTO userDTO = controllerSUT.registerUser(user);
		
		//ASSERT
		assertThat(userDTO.getInfo(), equalTo(registerService.registerUser(user).getInfo()));
	}

}
