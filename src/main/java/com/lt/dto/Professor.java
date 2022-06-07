package com.lt.dto;

public class Professor {
	private String profName;
	private String department;
	private String designation;
	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Professor(String profName, String department, String designation) {
		super();
		this.profName = profName;
		this.department = department;
		this.designation = designation;
	}
	public Professor() {
		super();
	}
	@Override
	public String toString() {
		return "Professor [profName=" + profName + ", department=" + department + ", designation=" + designation + "]";
	}
    
 
}
