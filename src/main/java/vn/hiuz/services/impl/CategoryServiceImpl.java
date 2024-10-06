package vn.hiuz.services.impl;

import java.util.List;

import vn.hiuz.dao.ICategoryDao;
import vn.hiuz.dao.impl.CategoryDaoImpl;
import vn.hiuz.models.CategoryModel;
import vn.hiuz.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{
	public CategoryDaoImpl catedao = new CategoryDaoImpl();
	@Override
	public List<CategoryModel> findALL() {
		// TODO Auto-generated method stub
		return catedao.findALL();
	}

	@Override
	public CategoryModel findById(int id) {
		// TODO Auto-generated method stub
		return catedao.findById(id);
	}

	@Override
	public void insert(CategoryModel category) {
		catedao.insert(category);
		
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = catedao.findById(category.getCategoryid());
		if(cate != null)
		{
			catedao.update(category);
		}
		
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = catedao.findById(id);
		if(cate != null)
		{
			catedao.delete(id);
		}
		
	}

	@Override
	public List<CategoryModel> findname(String keyword) {
		// TODO Auto-generated method stub
		return catedao.findname(keyword);
	}

}
