package com.entlogics.iplapp.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		System.out.println(session.isConnected());

		session.close();

	}

}
