package com.chgu.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chgu.data.model.Blogger;

public class HibernateBloggerReader implements IBlogger {

	private static SessionFactory sessionFactory = null;
	private Session session = null;

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure("hibernate/config.xml")
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

	public HibernateBloggerReader() {
		if (sessionFactory == null) {
			sessionFactory = buildSessionFactory();
			session = sessionFactory.openSession();
		}
	}

	@Override
	public int addBlogger() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Blogger getBlogger(int id) {
		Blogger blog = (Blogger) session.get(Blogger.class, id);
		// TODO Auto-generated method stub
		return blog;
	}

	@Override
	public int addBlogger(int id, String title, String category, String content) {
		try {
			session.beginTransaction();

			session.save(new Blogger(id, title, category, content));
		} finally {
			session.getTransaction().commit();
		}
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteBlog(int id) {
		// TODO Auto-generated method stub
		try {
			session.beginTransaction();
			session.delete(id);
		} finally {
			session.getTransaction().commit();
		}
	}

	@Override
	public void updateBlog(int id, String title, String category, String content) {
		// TODO Auto-generated method stub
		try {
			session.beginTransaction();
			session.update(new Blogger(id, title, category, content));
		} finally {
			session.getTransaction().commit();
		}
	}

	@Override
	public void updateBlog(Blogger blog) {
		// TODO Auto-generated method stub
		try {
			session.beginTransaction();
			session.update(blog);
		} finally {
			session.getTransaction().commit();
		}
	}

	@Override
	public void deleteBlog(Blogger blog) {
		// TODO Auto-generated method stub
		try {
			session.beginTransaction();
			session.delete(blog);
		} finally {
			session.getTransaction().commit();
		}
	}
}
