package com.tedu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tedu.bean.Book;
import com.tedu.util.DBUtil;

//模型层		--表示dao工厂，	---对d_book表的增删改查的操作
public class BookDao {
	//从d_book封装一个方法	--将d_book表中的所有数据查询出来
	public static ArrayList<Book> getBooks(){
		//创建一ArrayList集合，用于存储结果中集中查询的数据
		ArrayList<Book> books = new ArrayList<Book>();
		Connection con = DBUtil.getCon();
		String sql = "select * from d_book";
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			ResultSet rs = prep.executeQuery();
			//使用循环将rs结果数据依次遍历
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
				//每次循环将创建的书放入集合中存储
				books.add(b);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

}
