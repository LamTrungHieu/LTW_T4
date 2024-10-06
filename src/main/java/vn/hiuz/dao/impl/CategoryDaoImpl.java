package vn.hiuz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import vn.hiuz.configs.DBConnectMySQL;
import vn.hiuz.dao.ICategoryDao;
import vn.hiuz.models.CategoryModel;

public class CategoryDaoImpl implements ICategoryDao{
	
	public Connection conn=null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<CategoryModel> findALL() {
		String sql = "select * From categories";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setcategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
				
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryModel findById(int id) {
		String sql = "select * From categories where categoryid =?";
		
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setcategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				
				return category;
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void insert(CategoryModel category) {
String sql = "INSERT INTO categories(categoryname,images,status) VALUES (?,?,?)";
		
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getcategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			
			ps.executeUpdate();
			conn.close();
			ps.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel category) {
String sql = "UPDATE categories SET categoryname = ?, images=?, status =? WHERE categoryid = ?";
		
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getcategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4,category.getCategoryid());
			ps.executeUpdate();
			conn.close();
			ps.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
String sql = "DELETE FROM categoryies WHERE categoryid = ?";
		
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			conn.close();
			ps.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CategoryModel> findname(String keyword) {
		String sql = "select * From categories where categoryname like ?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+ keyword + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setcategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
