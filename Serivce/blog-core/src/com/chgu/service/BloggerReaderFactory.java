package com.chgu.service;

public class BloggerReaderFactory {
	public static IBlogger getBloggerReader(String type) throws Exception {
		IBlogger bloggerReader = null;
		
		switch (type) {
			case "JDBC" :
				bloggerReader = new JDBCBloggerReader();
				break;
				
			case "IBATIS" :
				bloggerReader = new IBatisBlogRead();
				break;
				
			case "HIBERNATE" :
				bloggerReader = new HibernateBloggerReader();
				break;
				
			default:
				throw new Exception("Unsupported blogger reader type!");	
		}
		
		return bloggerReader;
	}
}
