package btltweb5.iosstar.Service;
import java.util.List;
import btltweb5.iosstar.Model.categorymodel;
import btltweb5.iosstar.Service.implement.*;
import vn.iotstar.entity.Category;

public interface ICategoryService {

	List<categorymodel> findALL();
	categorymodel findById(int id); 
	List<categorymodel> findName(String keyword);
	void softDelete(categorymodel category);
	void insert(categorymodel category);
	void update(categorymodel category);
	void delete(int id);
}