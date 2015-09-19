package com.guch.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.guch.data.model.Blogger;

public class IBatisBlogRead implements IBlogger {

	SqlSessionFactory mSQLSessionFactory;
	SqlSession mSQLSession = null;

	public IBatisBlogRead() {
		loadIBatisConfig();
	}

	private void loadIBatisConfig() {
		try {
			String resource = "res/ibatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			mSQLSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
			mSQLSession = mSQLSessionFactory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int addBlogger(int id, String title, String category, String content) {
		// TODO Auto-generated method stub
		Blogger blog = new Blogger(id, title, category, content);
		int result = mSQLSession.insert(
				"com.guch.data.model.BloggerMap.create", blog);
		mSQLSession.commit();

		return result;
	}

	@Override
	public Blogger getBlogger(int id) {
		// TODO Auto-generated method stub
		Blogger blog = null;
		try {
			blog = mSQLSession.selectOne(
					"com.guch.data.model.BloggerMap.select", 1);
		} finally {
		}

		return blog;
	}

	@Override
	public int addBlogger() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteBlog(int id) {
		// TODO Auto-generated method stub
		mSQLSession.delete("com.guch.data.model.BloggerMap.delete", id);
		mSQLSession.commit();
	}

	@Override
	public void updateBlog(int id, String title, String category, String content) {
		// TODO Auto-generated method stub
		mSQLSession.update("com.guch.data.model.BloggerMap.update", new Blogger(id, title, category, content));
		mSQLSession.commit();
	}

	@Override
	public void updateBlog(Blogger blog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBlog(Blogger blog) {
		// TODO Auto-generated method stub
		
	}
}
