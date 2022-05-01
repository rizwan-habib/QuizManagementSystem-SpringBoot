package com.javahelps.persistance;

import java.util.ArrayList;

import java.util.List;

import com.javahelps.model.Student;
import com.javahelps.model.Teacher;


public interface PersistanceHandler {



	public boolean validateUserName(String username);
	public void saveStudent(Student person);
	public void saveTeacher(Teacher hostel);
	public boolean validateLogin(String login);
	public boolean getStudentbyUser(String username, String password);
	public boolean validateTLogin(String login);
	public boolean getTeacherbyUser(String username, String password);
}
