package com.tedu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.UserDao;

//���Ʋ�
//��������Servlet		--��������Ƿ�ע���
public class CheckEmailServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
						   HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String strEmail = req.getParameter("checkemail");
		//�ڿ��Ʋ����ģ�Ͳ�UserDao����
		boolean f = UserDao.getUserByEmail(strEmail);
		//System.out.println(f);
		//fֵΪtrue��ʾ�����Ѿ�Ϊע�������֮
		
		//�ڿ��Ʋ㽫���������ͼ�㣨Register.jsp��
		PrintWriter out = resp.getWriter();
		if(f){		//˵�������Ѿ���ע���
			out.println("1");
		}else{		//˵������û�б�ע���
			out.println("0");
		}
	}

}
