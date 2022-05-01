package com.javahelps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int TeacherID;
    
    
    private String name;

    private String username;
    private String university;
    private String department;
    private String password;

    
    public Teacher() {
		// TODO Auto-generated constructor stub
//    	isFullorNot();
	}


	public Teacher(String name, String username, String university, String department,
			String password) {
		super();
		this.name = name;
		this.username = username;
		this.university = university;
		this.department = department;
		this.password = password;
	}


	public int getTeacherID() {
		return TeacherID;
	}


	public void setTeacherID(int teacherID) {
		TeacherID = teacherID;
	}


	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
    
	
}
