package btltweb5.iosstar.Service.implement;

import java.util.List;

import btltweb5.iosstar.DAO.ICategoryDao;
import btltweb5.iosstar.DAO.implement.CategoryDaoImpl;
import btltweb5.iosstar.DAO.ICategoryDao;
import btltweb5.iosstar.Model.categorymodel;
import btltweb5.iosstar.Service.ICategoryService;
import btltweb5.iosstar.Service.implement.*;
import vn.iotstar.entity.Category;

public class CategoryServiceImpl implements ICategoryService {
public ICategoryDao cateDao= new CategoryDaoImpl();
	@Override
	public List<categorymodel> findALL() {
		
		return cateDao.findALL();
	}

	@Override
	public categorymodel findById(int id) {
	
		return cateDao.findById(id);
	}

	@Override
	public void insert(categorymodel category) {
	cateDao.insert(category);
		
	}

	@Override
	public void update(categorymodel category) {
		categorymodel cate=new categorymodel();
		cate= cateDao.findById(category.getCategoryid());
		if(cate !=null) {
			cateDao.update(category);
			
		}
	}

	@Override
	public void delete(int id) {
		categorymodel cate=new categorymodel();
		cate= cateDao.findById(id);
		if(cate !=null) {
			cateDao.delete(id);
			
		}
		
	}

	@Override
	public List<categorymodel> findName(String keyword) {
		return cateDao.findName(keyword);
	}

	@Override
	public void softDelete(categorymodel category) {
		cateDao.softDelete(category);
		
	}

}
