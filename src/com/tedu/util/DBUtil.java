package com.tedu.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	//��װ������ݿ����ӷ���
	public static Connection getCon() {
		Connection con = null;
		//1.ע���������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//������ݿ�����
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
