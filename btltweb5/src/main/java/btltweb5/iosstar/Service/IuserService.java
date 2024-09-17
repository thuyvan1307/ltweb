package btltweb5.iosstar.Service;

import btltweb5.iosstar.Model.usermodel;
public interface IuserService {
	usermodel login(String username, String password);
	usermodel FindByUserName(String username);
	void insert(usermodel user);
	boolean register(String username, String password, String email, String
	fullname, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	void updatePassword(String email, String NewPassword);
}
