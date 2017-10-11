package com.tedu.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.bean.Book;
import com.tedu.dao.BookDao;

//服务器端一个Servlet   ---将d_book中的23条数据显示在页面中
public class BookListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
						   HttpServletResponse resp)
			throws ServletException, IOException {
		//页面向服务器端发送请求，如果含有中文，采用utf-8
		req.setCharacterEncoding("utf-8");
		//服务器响应，如果含有中文，采用utf-8
		resp.setContentType("text/html;charset=utf-8");
		
		//Servlet属于控制层，负责调用模型层的数据
		ArrayList<Book> books = BookDao.getBooks();
		//将模型层的返回结果，转发到页面，交给页面，完成数据的显示
		req.setAttribute("bs", books);
		req.getRequestDispatcher("booklist.jsp").forward(req, resp);
	}
}
