package com.example.dao;

import java.sql.Timestamp;
import java.util.List;

public interface GenericDao <E> {
	public E findByName(String name);
	public E findById(int Id);
	public void Insert(E entity);
	public List<E> getAll(int Id);
	public String getUsernameById(int id);
	public String getStatusById(int id);
	public String getTypeById(int id);
	public List<E> getAllManager();
	public void update(int ID,Timestamp resolved,int status,int resolver);
}
