package com.javahelps.model;

import java.util.ArrayList;

import com.javahelps.persistance.PersistanceFactory;
import com.javahelps.persistance.PersistanceHandler;
import com.javahelps.persistance.PersistanceSingleton;

public class QuizManagementSystem {
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private PersistanceHandler persistancehandler;

	public QuizManagementSystem() {
		// TODO Auto-generated constructor stub
		PersistanceFactory perFactory = new PersistanceFactory();
		PersistanceSingleton singleton = PersistanceSingleton.getInstance();
		String db = singleton.getPersistance();
		persistancehandler = perFactory.getPersistance(db);

	}

	public String login(String username, String password) {
		return validateLogin(username, password);
	}

	private String validateLogin(String username, String password) {
		boolean flag = persistancehandler.getStudentbyUser(username, password);

		if (flag) {
			flag = persistancehandler.getTeacherbyUser(username, password);
			
		}
		else {
			
			return "student";
		}
		if (flag) {
			return "none";
		}
		return "teacher";
		
	}

	private boolean validateUser(String username) {
		return persistancehandler.validateUserName(username);
	}

	public String setUpProfile(String name, String cnic, String username, String password) {
		if (!validateUser(username)) {
			return "false";
		}
		Student resi = new Student();
		resi.setName(username);
		resi.setCnic(cnic);
		resi.setUsername(username);
		resi.setPassword(password);

		students.add(resi);
		persistancehandler.saveStudent(resi);
		return "success";
	}
    public boolean validateTeacher(String login) {
    	return persistancehandler.validateTLogin(login);	
    }
    public boolean validateHostellogin(String login) {
    	return persistancehandler.validateLogin(login);	
    }
    public String enterTeacherDetails(String teacherName, String university, String department, String login,
			String password) {
    	if (! validateTeacher(login) ) {
			return 	"login_false";
		}
		Teacher host=new Teacher();
		host.setName(teacherName);
		host.setUniversity(university);
		host.setPassword(password);
		host.setUsername(login);
		host.setDepartment(department);
		teachers.add(host);
		persistancehandler.saveTeacher(host);
		return "success";
    
	}

	

}
