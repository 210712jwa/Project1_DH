package com.revature.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.revature.model.User;
import com.revature.util.SessionFactorySingleton;

public class Main {

	public static void main(String[] args) {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();

		 addFirstUser();
		
//		retrieveFirstShipAdded();

//		addANewPirate();
		
//		addEvenMorePirates();
		
//		modifyNameOfShip();
		
		// Get all pirates from ship w/ a certain id
//		getAllPiratesFromShipId(1);
	}

//
	private static void addFirstUser() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
	
		User newUser = new User("username","password","david", "huynh", "david@revature.net");
		session.persist(newUser);
		
		tx.commit();
		
		session.close();
	}
}
//	
//	private static void retrieveFirstShipAdded() {
//		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Ship ship = session.get(Ship.class, 1); // get a Ship w/ id 1	
//		System.out.println(ship);
//		
//		tx.commit();
//		session.close();
//	}
//	
//	private static void addANewPirate() {
//		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Ship ship = session.get(Ship.class, 1); // Grab the ship we want to add the pirate to
//		
//		 // 3 object states: Transient, Persistent, Detached
//		
//		Pirate pirate = new Pirate("Jack Sparrow", 25);
//		session.persist(pirate);
//		pirate.setShip(ship); // We are adding this pirate to the ship
//		
//		tx.commit();
//		session.close();
//	}
//	
//	
//	private static void addEvenMorePirates() {
//		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Ship ship = session.get(Ship.class, 1);
//		
//		Pirate p1 = new Pirate("David Huynh", 123);
//		Pirate p2 = new Pirate("Nicholas Hailey", 200);
//		Pirate p3 = new Pirate("Santana Chiluisa", 50);
//		Pirate p4 = new Pirate("McCabe Sommers", 23);
//		
//		p1.setShip(ship);
//		p2.setShip(ship);
//		p3.setShip(ship);
//		p4.setShip(ship);
//		
//		session.persist(p1);
//		session.persist(p2);
//		session.persist(p3);
//		session.persist(p4);
//		
//		tx.commit();
//		session.close();
//	}
//	
//	private static void modifyNameOfShip() {
//		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Ship ship = session.get(Ship.class, 1);
//		ship.setName("Queen Anne's Revenge");
//		
//		tx.commit();
//		session.close();
//	}
//	
//	private static void getAllPiratesFromShipId(int id) {
//		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		
//	
////		Ship ship = (Ship) session.createQuery("FROM Ship s WHERE s.id = 1").getSingleResult();
////		System.out.println(ship);
//		
//		List<Pirate> piratesFromShip = session.createQuery("SELECT p FROM Pirate p JOIN p.ship s WHERE s.id = :id")
//				.setParameter("id", id).getResultList();
//		System.out.println(piratesFromShip);
//				
//		tx.commit();
//		session.close();
//	}
//
//}
