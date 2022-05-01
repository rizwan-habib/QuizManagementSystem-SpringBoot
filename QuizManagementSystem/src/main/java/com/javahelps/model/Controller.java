package com.javahelps.model;



public class Controller {
	private static Controller INSTANCE = null;
	QuizManagementSystem system;
	private Controller() {
		// TODO Auto-generated constructor stub
		system=new QuizManagementSystem();
	}
	public static Controller getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Controller();

		return INSTANCE;
	}
	public static void setINSTANCE(Controller iNSTANCE) {
		INSTANCE = iNSTANCE;
	}
	public String login(String username,String password) {
		return system.login(username, password);
	}
	public String setUpProfile(String name,String cnic,String username,String password) {
			return system.setUpProfile(name, cnic, username, password);
	}
	
	
	public String enterTeacherDetails(String teacherName, String university, String department, String login,
			String password) {
		return system.enterTeacherDetails(teacherName, university,department ,login, password);
	}
	
}
