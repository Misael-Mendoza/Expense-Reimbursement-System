package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Reimbursement;


public class ReimbursementDao implements GenericDao<Reimbursement> {
	
	private ERSDBConnection rdc;
	
	
	public ReimbursementDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ReimbursementDao(ERSDBConnection rdc) {
		this.rdc = rdc;
	}

	@Override
	public Reimbursement findByName(String name) {
		Reimbursement reinbursement = null;
		try(Connection con = rdc.getDBConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (!rs.first()) {
				return null;
			}
		
			reinbursement = new Reimbursement(rs.getInt(1),rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4),rs.getString(5),
					""+rs.getInt(6),""+rs.getInt(7),""+rs.getInt(8),""+rs.getInt(9));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reinbursement;
	}

	@Override
	public Reimbursement findById(int Id) {
		Reimbursement reinbursement = null;
		try(Connection con = rdc.getDBConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			if (!rs.first()) {
				return null;
			}
			String username = getUsernameById(rs.getInt(6));
			String resolver = getUsernameById(rs.getInt(7));
			String status = getStatusById(rs.getInt(8));
			String type = getTypeById(rs.getInt(9));
			reinbursement = new Reimbursement(rs.getInt(1),rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4),rs.getString(5),
					username,resolver,status,type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reinbursement;
	}

	@Override
	public void Insert(Reimbursement entity) {
		try(Connection con = rdc.getDBConnection()){
			String sql = "INSERT INTO ERS_REIMBURSEMENT(REIMB_AMOUNT,REIMB_SUBMITTED,REIMB_DESCRIPTION,REIMB_AUTHOR,REIMB_STATUS_ID,REIMB_TYPE_ID) " + 
						 "VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, entity.getAmount());
			ps.setTimestamp(2,entity.getSubmitted());
			ps.setString(3, entity.getDescription());
			ps.setInt(4,Integer.parseInt(entity.getAuthor()));
			ps.setInt(5, Integer.parseInt(entity.getStatusId()));
			ps.setInt(6,Integer.parseInt(entity.getTypeId()));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String getUsernameById(int id){
		String username = "";
		try(Connection con = rdc.getDBConnection()){
			String sql = "SELECT ERS_USERNAME FROM ERS_USERS WHERE ERS_USERS_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				username = rs.getString(1);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return username;
	}
	
	@Override
	public String getStatusById(int id) {
		String status = "";
		try(Connection con = rdc.getDBConnection()){
			String sql = "SELECT REIMB_STATUS FROM ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = rs.getString(1);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public String getTypeById(int id) {
		String type = "";
		try(Connection con = rdc.getDBConnection()){
			String sql = "SELECT REIMB_TYPE FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				type = rs.getString(1);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}
	
	
	@Override
	public List<Reimbursement> getAll(int Id) {
		
		List<Reimbursement> ReimbList = new ArrayList();
		try(Connection con = rdc.getDBConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String username = getUsernameById(rs.getInt(6));
				String resolver = getUsernameById(rs.getInt(7));
				String status = getStatusById(rs.getInt(8));
				String type = getTypeById(rs.getInt(9));
				ReimbList.add(new Reimbursement(rs.getInt(1),rs.getDouble(2),rs.getTimestamp(3),rs.getTimestamp(4),rs.getString(5),username,resolver,status,type));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ReimbList;
	}

	@Override
	public List<Reimbursement> getAllManager() {
		List<Reimbursement> ReimbList = new ArrayList();
		try(Connection con = rdc.getDBConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String username = getUsernameById(rs.getInt(6));
				String resolver = getUsernameById(rs.getInt(7));
				String status = getStatusById(rs.getInt(8));
				String type = getTypeById(rs.getInt(9));
				ReimbList.add(new Reimbursement(rs.getInt(1),rs.getDouble(2),rs.getTimestamp(3),rs.getTimestamp(4),rs.getString(5),username,resolver,status,type));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ReimbList;
	}

	@Override
	public void update(int ID, Timestamp resolved, int status,int resolver) {
		try (Connection con = rdc.getDBConnection()){
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED = ?, REIMB_RESOLVER = ?, REIMB_STATUS_ID = ? WHERE REIMB_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setTimestamp(1, resolved);
			ps.setInt(2, resolver);
			ps.setInt(3, status);
			ps.setInt(4, ID);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	

}
