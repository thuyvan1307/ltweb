package btltweb5.iosstar.DAO;
import btltweb5.iosstar.Model.usermodel;
import java.util.List;

public interface IUserDAO {

	List<usermodel> findAll();
	usermodel findById(int id);
	void insert(usermodel user);
	void updatePassword(String email, String NewPassword);
	usermodel findByUserName(String username);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	
}