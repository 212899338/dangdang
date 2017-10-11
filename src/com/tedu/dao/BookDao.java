package com.tedu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tedu.bean.Book;
import com.tedu.util.DBUtil;

//ģ�Ͳ�		--��ʾdao������	---��d_book�����ɾ�Ĳ�Ĳ���
public class BookDao {
	//��d_book��װһ������	--��d_book���е��������ݲ�ѯ����
	public static ArrayList<Book> getBooks(){
		//����һArrayList���ϣ����ڴ洢����м��в�ѯ������
		ArrayList<Book> books = new ArrayList<Book>();
		Connection con = DBUtil.getCon();
		String sql = "select * from d_book";
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			ResultSet rs = prep.executeQuery();
			//ʹ��ѭ����rs����������α���
			while (rs.next()) {
				Book b = new Book();
				b.id = rs.getInt("id");
				b.productName = rs.getString("product_name");
				b.description = rs.getString("description");
				b.fixedPrice = rs.getDouble("fixed_price");
				b.dangPrice = rs.getDouble("dang_price");
				b.productpic = rs.getString("product_pic");
				b.author = rs.getString("author");
				b.authorsummary = rs.getString("author_summary");
				b.publishing = rs.getString("publishing");
				Date d = new Date(rs.getLong("publish_time"));
				b.publishTime = d;
				//ÿ��ѭ��������������뼯���д洢
				books.add(b);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

}
