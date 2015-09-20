package com.guch.test;

import com.guch.data.model.Blogger;
import com.guch.service.BloggerReaderFactory;
import com.guch.service.IBlogger;

import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

public class ReadTest extends PowerMockTestCase {
	
	@Test
	public void getBloggerTest() {

		try {
			// TODO Auto-generated method stub
			System.out.println("Read from datatbase.");

			IBlogger blogger = BloggerReaderFactory
					.getBloggerReader("IBATIS");

			/**
			 * select, add, update and delete operation
			 */
			Blogger blog = blogger.getBlogger(2);
			blogger.addBlogger(3, "学习swift", "前沿", "Apple Swift可能会比较流行。");

			blog = blogger.getBlogger(3);
			blog.setTitle("学习swift");
			blog.setCategory("更新后");
			blog.setContent("Apple Swift降低了学习门槛。");

			// blogger.updateBlog(3, "学习swift", "更新后", "Apple Swift降低了学习门槛。");
			blogger.updateBlog(blog);

			// blogger.deleteBlog(3);
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
