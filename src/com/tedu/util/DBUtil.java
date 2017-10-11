package com.tedu.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	//封装获得数据库链接方法
	public static Connection getCon() {
		Connection con = null;
		//1.注册加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//获得数据库链接
			String url = "jdbc:mysql://localhost:3306/dang?useUnicode=true&characterEncoding=utf8";
			String usename = "root";
			String password = "";
			con = DriverManager.getConnection(url,usename,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
