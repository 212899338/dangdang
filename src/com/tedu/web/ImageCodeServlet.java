package com.tedu.web;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

//���Ʋ�
//�����һ��Servlet	---������֤��
public class ImageCodeServlet extends HttpServlet{

	protected void service(HttpServletRequest req, 
						   HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("image/jpg");
		BufferedImage image = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random r = new Random();
		g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		g.fillRect(0, 0, 60, 20);
		
		int num = r.nextInt(9999);
		
		//��ȡsession���ڷ������˴洢����
		HttpSession session = req.getSession();
		session.setAttribute("num", num+"");//�������������֤��洢��session��
		
		
		g.setColor(new Color(0,0,0));
		g.drawString(num+"", 10, 15);
		
		g.drawLine(r.nextInt(60), r.nextInt(20), r.nextInt(60), r.nextInt(20));
		g.drawLine(r.nextInt(60), r.nextInt(20), r.nextInt(60), r.nextInt(20));
		g.drawLine(r.nextInt(60), r.nextInt(20), r.nextInt(60), r.nextInt(20));
		g.drawLine(r.nextInt(60), r.nextInt(20), r.nextInt(60), r.nextInt(20));
		
		OutputStream os = resp.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		encoder.encode(image);
	}

}
