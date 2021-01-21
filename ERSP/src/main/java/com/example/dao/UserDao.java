package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.example.model.User;

public class UserDao implements GenericDao<User> {
	
	private ERSDBConnection udc;
	
	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDao(ERSDBConnection udc) {
		this.udc = udc;
	}

	@Override
	public User findByName(String name) {
		User user = null;
		try(Connection con = udc.getDBConnection()){
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (!rs.first()) {
				return null;
			}
			user = new 	User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User findById(int Id) {
		
		User user = null;
		try(Connection con = udc.getDBConnection()){
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERS_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			if (!rs.first()) {
				return null;
			}
			user = new 	User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void Insert(User entity) {
		try(Connection con = udc.getDBConnection()){
			String sql = "INSERT INTO ERS_USERS(ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getUsername());
			ps.setString(2, entity.getPassword());
			ps.setString(3, entity.getFirstName());
			ps.setString(4, entity.getLastName());
			ps.setString(5, entity.getEmail());
			ps.setInt(6, entity.getRoleId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAll(int Id) {
		
		return null;
	}

	@Override
	public String getUsernameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatusById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTypeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(int ID, Timestamp resolved, int status, int resolver) {
		// TODO Auto-generated method stub
		
	}



}
