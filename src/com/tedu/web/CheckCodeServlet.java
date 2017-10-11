package com.tedu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckCodeServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, 
					   HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String strCode = request.getParameter("coed");
		//System.out.println(strCode);
		//从session去除验证码
		HttpSession session = request.getSession();
		String number = (String)session.getAttribute("num");
		//System.out.println(""+number);
		PrintWriter out = response.getWriter();
		if(strCode.equals(number)){		//如果if条件一致，说明图片与输入是一致
			out.println("1");
		}else{		//反之
			out.println("0");
		}
		
	}

}
 