package com.example.model;


import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Reimbursement {
	private int ReimbId;
	private double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private String author;
	private String resolver;
	private String statusId;
	private String typeId;
	
	public Reimbursement() {
		// TODO Auto-generated constructor stub
	}
	
	public Reimbursement( double amount, Timestamp submitted, Timestamp resolved, String description,
		String author, String resolver, String statusId, String typeId) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public Reimbursement(int reimbId, double amount, Timestamp submitted, Timestamp resolved, String description,
			String author, String resolver, String statusId, String typeId) {
		super();
		this.ReimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	
	public Reimbursement(double amount, Timestamp submitted, String description,
			String author, String statusId, String typeId) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.author = author;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public int getReimbId() {
		return ReimbId;
	}

	@Override
	public String toString() {
		return "Reimbursement [ReimbId=" + ReimbId + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", author=" + author
				+ ", resolver=" + resolver + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}
	
	
	
}
