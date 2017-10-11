package com.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.UserDao;
		//控制层
		//服务器端的一个servlet -- 接收注册页面提交的数据，并插入到数据库中
public class RegisterServlet extends HttpServlet{
			
			protected void service(HttpServletRequest req,
					HttpServletResponse resp) 
			throws ServletException,IOException {	
				
				req.setCharacterEncoding("utf-8");//设置中文编码
				resp.setContentType("text/html;charset=utf-8");
				//接收register.jsp页面提交过来的表单数据（邮箱、昵称、密码）
				String strEmail=req.getParameter("email");	
				String strNickName=req.getParameter("nickname");
				String strPwd=req.getParameter("password");
				System.out.println(strEmail+","+strNickName+","+strPwd);
				//调用模型层，将邮箱，昵称和密码插入到数据库中
				UserDao.regist(strEmail,strNickName,strPwd);
				//插入数据成功之后，直接跳转到login.jsp页面
				//重定向到login.jsp
				resp.sendRedirect("login.jsp");
				//转发：servlet将未完成的工作交给下一个组件完成用转发
				//重定向：servlet已经完成了，直接跳转用重定向
			}
}