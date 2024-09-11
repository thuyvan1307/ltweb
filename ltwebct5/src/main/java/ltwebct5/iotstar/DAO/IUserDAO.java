package ltwebct5.iotstar.DAO;

	

import java.util.List;

import ltwebct5.iotstar.Model.usermodel;

public interface IUserDAO {

	List<usermodel> findall();
	
	usermodel findByID(int id); 
	usermodel findByName(String name);
	usermodel login (String username, String password);
	void insert (usermodel user);

}

