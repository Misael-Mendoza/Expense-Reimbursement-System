package com.example.service;

import java.sql.Timestamp;
import java.util.List;

import com.example.dao.ReimbursementDao;
import com.example.model.Reimbursement;

public class ReimbursementService {
	private ReimbursementDao rDao;
	
	public ReimbursementService() {
		// TODO Auto-generated constructor stub
	}

	public ReimbursementService(ReimbursementDao rDao) {
		super();
		this.rDao = rDao;
	}
	
	public Reimbursement getReimbursement(String name) {
		Reimbursement reimbursement = rDao.findByName(name); 
		if (reimbursement == null) {
			throw new NullPointerException();
		}
		return reimbursement;
	}
	
	public void addReimbursement(double amount,Timestamp submitted, String description, String author,String status,String type) {
		Reimbursement reimb = new Reimbursement(amount,submitted,description,author,status,type);
		rDao.Insert(reimb);
	}
	
	public List<Reimbursement> getAllReimbursements(int id){
		List<Reimbursement> temp = rDao.getAll(id);
		return temp;
	}
	
	public List<Reimbursement> getAllForManager(){
		List<Reimbursement> temp = rDao.getAllManager();
		return temp;
	}
	
	public Reimbursement getReimbursementById(int id) {
		return rDao.findById(id);
	}
	
	public void updateReimbursement(int id,Timestamp resolved,int resolver,int status) {
		rDao.update(id, resolved, status, resolver);
	}
	
}
