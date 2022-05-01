package com.javahelps.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.javahelps.model.Student;
import com.javahelps.model.Teacher;

public class MySQLHandler implements PersistanceHandler {
	private SessionFactory sf;

	public MySQLHandler() {
		// TODO Auto-generated constructor stub
		Configuration con = new Configuration();
		con.configure().addAnnotatedClass(Student.class);
		con.configure().addAnnotatedClass(Teacher.class);
//		con.configure().addAnnotatedClass(ReservationRequests.class);
//		con.configure().addAnnotatedClass(Room.class);
		sf = con.buildSessionFactory();
	}

	@SuppressWarnings("rawtypes")
	public boolean validateUserName(String username) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List residents = session.createQuery("from Student where username = :user").setParameter("user", username)
				.list();

		trans.commit();
		session.close();
		if (residents.isEmpty()) {
			return true;
		}
		return false;
	}
	@Override
	public boolean validateTLogin(String login) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List hostels = session.createQuery("from Teacher where username = :user").setParameter("user", login).list();

		trans.commit();
		session.close();
		if (hostels.isEmpty()) {
			return true;
		}
		return false;
	}
//	@SuppressWarnings("rawtypes")
//	public boolean validateAddress(String address) {
//		Session session = sf.openSession();
//		Transaction trans = session.beginTransaction();
//		List hostels = session.createQuery("from Hostel where address = :user").setParameter("user", address).list();
//
//		trans.commit();
//		session.close();
//		if (hostels.isEmpty()) {
//			return true;
//		}
//		return false;
//	}

	public void saveStudent(Student person) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		session.save(person);
		trans.commit();
		session.close();
	}

	public void saveTeacher(Teacher teacher) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		session.save(teacher);
		trans.commit();
		session.close();
	}

	@SuppressWarnings("rawtypes")
	public boolean validateLogin(String login) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List hostels = session.createQuery("from Student where login = :user").setParameter("user", login).list();

		trans.commit();
		session.close();
		if (hostels.isEmpty()) {
			return true;
		}

		return false;
	}

//	@SuppressWarnings("rawtypes")
//	public ArrayList<Hostel> getHostels() {
//		Session session = sf.openSession();
//		Transaction trans = session.beginTransaction();
//		List hostels = session.createQuery("from Hostel").list();
//		trans.commit();
//		session.close();
//		ArrayList<Hostel> res = new ArrayList<Hostel>();
//		for (Iterator iterator = hostels.iterator(); iterator.hasNext();) {
//			res.add((Hostel) iterator.next());
//		}
//		if (hostels.isEmpty()) {
//			return null;
//		}
//		return res;
//	}
//	@SuppressWarnings("rawtypes")
//	public ArrayList<Resident> getResidents() {
//		Session session = sf.openSession();
//		Transaction trans = session.beginTransaction();
//		List resident = session.createQuery("from Resident").list();
//		trans.commit();
//		session.close();
//		ArrayList<Resident> res = new ArrayList<Resident>();
//		for (Iterator iterator = resident.iterator(); iterator.hasNext();) {
//			res.add((Resident) iterator.next());
//		}
//		if (resident.isEmpty()) {
//			return null;
//		}
//		return res;
//	}
//	public void updateHosteltoDB(Hostel hos, List<Room> list, Room room) {
//		// TODO Auto-generated method stub
//		Session session = sf.openSession();
//		Transaction trans = session.beginTransaction();
//		Hostel hostel = session.get(Hostel.class, hos.getHostelID());
//		hostel.setRooms(list);
////        hostel=hos;
//		room.setHostel(hostel);
//		session.saveOrUpdate(hostel);
//		session.saveOrUpdate(room);
////		for (int i = 0; i < hostel.getRequests().size(); i++) {
////			session.saveOrUpdate(hostel.getRequests().get(i));
////		}
//		trans.commit();
//		session.close();
//	}

	@SuppressWarnings("rawtypes")
	public boolean getStudentbyUser(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List hostels = session.createQuery("from Student where username = :user and password = :pass")
				.setParameter("user", username).setParameter("pass", password).list();

		trans.commit();
		session.close();
		if (hostels.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getTeacherbyUser(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		List hostels = session.createQuery("from Teacher where username = :user and password = :pass")
				.setParameter("user", username).setParameter("pass", password).list();

		trans.commit();
		session.close();
		if (hostels.isEmpty()) {
			return true;
		}
		return false;
	}

}
