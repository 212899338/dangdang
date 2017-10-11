package com.tedu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.UserDao;

//控制层
//服务器端Servlet		--检测邮箱是否被注册过
public class CheckEmailServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
						   HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String strEmail = req.getParameter("checkemail");
		//在控制层调用模型层UserDao方法
		boolean f = UserDao.getUserByEmail(strEmail);
		//System.out.println(f);
		//f值为true表示邮箱已经为注册过，反之
		
		//在控制层将结果返回视图层（Register.jsp）
		PrintWriter out = resp.getWriter();
		if(f){		//说明邮箱已经被注册过
			out.println("1");
		}else{		//说明邮箱没有被注册过
			out.println("0");
		}
	}

}
