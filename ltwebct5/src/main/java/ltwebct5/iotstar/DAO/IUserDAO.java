package ltwebct5.iotstar.DAO;

import java.util.List;

public interface IUserDAO {

	List<UserModel> findall();
	
	UserModel findByID(int id); 
	
	void insert (UserModel user);
    UserModel findByUserName(String username);

