package com.tedu.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.bean.Book;
import com.tedu.dao.BookDao;

//��������һ��Servlet   ---��d_book�е�23��������ʾ��ҳ����
public class BookListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
						   HttpServletResponse resp)
			throws ServletException, IOException {
		//ҳ����������˷�����������������ģ�����utf-8
		req.setCharacterEncoding("utf-8");
		//��������Ӧ������������ģ�����utf-8
		resp.setContentType("text/html;charset=utf-8");
		
		//Servlet���ڿ��Ʋ㣬�������ģ�Ͳ������
		ArrayList<Book> books = BookDao.getBooks();
		//��ģ�Ͳ�ķ��ؽ����ת����ҳ�棬����ҳ�棬������ݵ���ʾ
		req.setAttribute("bs", books);
		req.getRequestDispatcher("booklist.jsp").forward(req, resp);
	}
}
