package com.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.UserDao;
		//���Ʋ�
		//�������˵�һ��servlet -- ����ע��ҳ���ύ�����ݣ������뵽���ݿ���
public class RegisterServlet extends HttpServlet{
			
			protected void service(HttpServletRequest req,
					HttpServletResponse resp) 
			throws ServletException,IOException {	
				
				req.setCharacterEncoding("utf-8");//�������ı���
				resp.setContentType("text/html;charset=utf-8");
				//����register.jspҳ���ύ�����ı����ݣ����䡢�ǳơ����룩
				String strEmail=req.getParameter("email");	
				String strNickName=req.getParameter("nickname");
				String strPwd=req.getParameter("password");
				System.out.println(strEmail+","+strNickName+","+strPwd);
				//����ģ�Ͳ㣬�����䣬�ǳƺ�������뵽���ݿ���
				UserDao.regist(strEmail,strNickName,strPwd);
				//�������ݳɹ�֮��ֱ����ת��login.jspҳ��
				//�ض���login.jsp
				resp.sendRedirect("login.jsp");
				//ת����servlet��δ��ɵĹ���������һ����������ת��
				//�ض���servlet�Ѿ�����ˣ�ֱ����ת���ض���
			}
}