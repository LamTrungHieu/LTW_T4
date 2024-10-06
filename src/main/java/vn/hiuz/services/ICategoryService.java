package vn.hiuz.services;

import java.util.List;

import vn.hiuz.models.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findALL();
	CategoryModel findById(int id);
	void insert(CategoryModel category);
	void update(CategoryModel category);
	void delete(int id);
	List<CategoryModel> findname(String keyword);
}
