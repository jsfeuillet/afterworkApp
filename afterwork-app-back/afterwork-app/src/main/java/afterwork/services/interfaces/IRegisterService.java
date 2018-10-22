package afterwork.services.interfaces;

import afterwork.controller.model.User;
import afterwork.dto.InfoDTO;

public interface IRegisterService {

	InfoDTO registerUser(User user);

}
