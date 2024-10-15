package btltweb5.iosstar.DAO;  

import java.util.List;

import btltweb5.iosstar.Model.categorymodel;

public interface ICategoryDao {

	List<categorymodel> findALL();
	categorymodel findById(int id); 
	List<categorymodel> findName(String keyword);
	void softDelete(categorymodel category);
	void insert(categorymodel category);
	void update(categorymodel category);
	void delete(int id);
}
