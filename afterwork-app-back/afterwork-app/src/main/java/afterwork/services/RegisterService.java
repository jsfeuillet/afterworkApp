package afterwork.services;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afterwork.controller.model.User;
import afterwork.dao.interfaces.IUserDAO;
import afterwork.dto.InfoDTO;
import afterwork.services.interfaces.IRegisterService;

@Service
public class RegisterService implements IRegisterService {

	@Autowired
	private IUserDAO userDAO;

	public InfoDTO registerUser(User user) {
		InfoDTO userStatus = new InfoDTO();
		
		if(!isValidMail(user.getMail())) {
			userStatus.setInfo("NOK_MAIL_BAD");
		}
		else if(!isValidUsername(user.getUsername())) {
			userStatus.setInfo("NOK_USER_BAD");
		}
		else if(userMailAlreadyRegistered(user.getMail())) {
			userStatus.setInfo("NOK_MAIL");
		}
		else {
			userDAO.insertUser(user);
			userStatus.setInfo("OK");
		}
		return userStatus;
	}

	private boolean userMailAlreadyRegistered(String mail) {
		User userByMail = userDAO.getUserByMail(mail);
		boolean userRegistered = false;
		if(userByMail != null) {
			userRegistered = true;
		}
		return userRegistered;
	}
	
	private static boolean isValidMail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
	
	private static boolean isValidUsername(String username) 
    { 
        String userNameRegex = "^[a-zA-Z0-9]+$"; 
                              
        Pattern pat = Pattern.compile(userNameRegex); 
        if (username == null) 
            return false; 
        return pat.matcher(username).matches(); 
    } 
	
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;		
	}

}
