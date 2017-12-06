package mc.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import mc.dao.UserDAO;
import mc.model.User;

@Service
@Transactional
public class UserService {

	private final UserDAO userDAO;
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User findByUserNameAndPwd(String userName,String pwd){
		return userDAO.findByUserNameAndPwd(userName,pwd);
	}
}
