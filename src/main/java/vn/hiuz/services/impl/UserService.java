package vn.hiuz.services.impl;

import vn.hiuz.dao.IUserDao;
import vn.hiuz.dao.impl.UserDaoImpl;
import vn.hiuz.models.UserModel;
import vn.hiuz.services.IUserService;

public class UserService implements IUserService {
	// Lấy toàn bộ hàm trong tầng Dao của User
	IUserDao userDao = new UserDaoImpl();
	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
		return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		
		return userDao.findByUsername(username);
	}

}
