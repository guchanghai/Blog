/**
 * 
 */
package com.chgu.service;

import com.chgu.data.model.Blogger;

/**
 * @author chgu
 *
 */
public interface IBlogger {
	
	int addBlogger();
	
	Blogger getBlogger(int id);

	int addBlogger(int id, String title, String category, String content);
	
	void updateBlog(int id, String title, String category, String content);
	
	void updateBlog(Blogger blog);

	void deleteBlog(int id);

	void deleteBlog(Blogger blog);
}
