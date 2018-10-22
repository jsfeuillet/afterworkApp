package afterwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import afterwork.controller.model.User;
import afterwork.dto.InfoDTO;
import afterwork.services.interfaces.IRegisterService;

@RestController
public class RegisterController {

	@Autowired
	private IRegisterService registerService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, headers="Content-Type=application/json")
	public InfoDTO registerUser(@RequestBody User user) {
		return registerService.registerUser(user);		
	}

	public void setRegisterService(IRegisterService registerService) {
		this.registerService = registerService;		
	}

}
