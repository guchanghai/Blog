package com.chgu.test;

import com.chgu.data.model.Blogger;
import com.chgu.service.BloggerReaderFactory;
import com.chgu.service.IBlogger;

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
			blogger.addBlogger(3, "学习swift", "前沿", "Apple Swift可能会比较流行。");

			Blogger blog = blogger.getBlogger(3);
			blog.setTitle("学习swift");
			blog.setCategory("更新后");
			blog.setContent("Apple Swift降低了学习门槛。");

			blogger.updateBlog(blog);

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
