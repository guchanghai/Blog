package com.guch.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.guch.data.model.Blogger;

public class JDBCBloggerReader implements IBlogger {
	
	Connection mConn;
	Statement mStmt = null;
	ResultSet mResult = null;
	
	private boolean connectToDB() {
		
		try {
			mConn = DriverManager.getConnection("jdbc:mysql://localhost/BLOGDB?" +
		                                   "user=jemdevuser&password=toad307)laze");

		    // Do something with the Connection
		    mStmt = mConn.createStatement();

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    return false;
		}
		
		return true;
	}
	
	private ResultSet readBlog(int id) {

		try {
		    mResult = mStmt.executeQuery("SELECT * FROM BLOG WHERE id = '" + id + "'");
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return mResult;
	}

	@Override
	public int addBlogger() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Blogger getBlogger(int id) {
		Blogger blogger = null;
		
		try {
			if (this.connectToDB()) {
				System.out.println("Connect DB successfully!");
				
				ResultSet rs = this.readBlog(id);
				if (rs.next()) {
//					System.out.print(rs.getString(1) + "\t");
//					System.out.print(rs.getString(2) + "\t");
//					System.out.print(rs.getString(3) + "\t");
//					System.out.print(rs.getString(4) + "\n");
					
					blogger = new Blogger(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// it is a good idea to release
			// resources in a finally{} block
			// in reverse-order of their creation
			// if they are no-longer needed
			if (mResult != null) {
				try {
					mResult.close();
				} catch (SQLException sqlEx) {
				} // ignore
			}

			if (mStmt != null) {
				try {
					mStmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				mStmt = null;
			}
		}
		
		// TODO Auto-generated method stub
		return blogger;
	}

	@Override
	public int addBlogger(int id, String title, String category, String content) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteBlog(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateBlog(int id, String title, String category, String content) {
		// TODO Auto-generated method stub
		
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
