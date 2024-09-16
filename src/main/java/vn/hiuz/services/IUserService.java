package vn.hiuz.services;

import vn.hiuz.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	UserModel FindByUserName(String username);
	
}
