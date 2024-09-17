package btltweb5.iosstar.Service.implement;

import btltweb5.iosstar.Service.IuserService;
import btltweb5.iosstar.Model.usermodel;

import java.sql.Date;
import java.time.LocalDate;

import btltweb5.iosstar.DAO.*;
import btltweb5.iosstar.DAO.implement.userDAOimplement;
public class userServiceImplement implements IuserService{

	IUserDAO userDAO = new userDAOimplement();
	@Override
	public usermodel login(String username, String password) {
		usermodel user = this.FindByUserName(username);
		if (user != null && password .equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public usermodel FindByUserName(String username) {
		return userDAO.findByUserName(username);
	}
	
	

	@Override
	public boolean register(String username, String password, String email, String fullname, String phone) {
			if (userDAO.checkExistUsername(username)) {
			return false;
			}
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDAO.insert(new usermodel(username, password, email ,fullname, null, 4 ,Date.valueOf(LocalDate.of(2024, 9, 15))));
			return true;
	}
	
		@Override
		public boolean checkExistEmail(String email) {
		return userDAO.checkExistEmail(email);
		}
		public boolean checkExistUsername(String username) {
		return userDAO.checkExistUsername(username);
		}
		@Override
		public boolean checkExistPhone(String phone) {
		return userDAO.checkExistPhone(phone);
		}
		
		@Override
		public void insert(usermodel user) {
			userDAO.insert(user);
		}
		
		public void updatePassword(String email, String NewPassword)
		{
			userDAO.updatePassword(email, NewPassword);
		}
	
	public static void main(String[] agrs)
	{
		IuserService test = new userServiceImplement();
		test.register("van", "1", "van@", "NTD", "113166");
	}

}
