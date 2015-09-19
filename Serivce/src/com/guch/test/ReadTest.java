package com.guch.test;

import com.guch.data.model.Blogger;
import com.guch.service.BloggerReaderFactory;
import com.guch.service.IBlogger;

public class ReadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Read from datatbase.");
		
		try {
			IBlogger blogger = BloggerReaderFactory.getBloggerReader("HIBERNATE");
			
			/**
			 * select, add, update and delete operation
			 */
			Blogger blog = blogger.getBlogger(2);
			blogger.addBlogger(3, "学习swift", "前沿", "Apple Swift可能会比较流行。");
			
			blog = blogger.getBlogger(3);
			blog.setTitle("学习swift");
			blog.setCategory("更新后");
			blog.setContent("Apple Swift降低了学习门槛。");
			
			//blogger.updateBlog(3, "学习swift", "更新后", "Apple Swift降低了学习门槛。");
			blogger.updateBlog(blog);
			
			//blogger.deleteBlog(3);
			blogger.deleteBlog(blog);
			
			if (blog != null) {
				System.out.println(blog.getContent());				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
