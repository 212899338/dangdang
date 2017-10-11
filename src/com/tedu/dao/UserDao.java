package com.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tedu.util.DBUtil;
		//模型层
		//该 UserDao主要封装对d_user表的操作
public class UserDao {
			//封装一个方法  -- 将表单提交的数据插入到d_user表中
	public static void regist(String email,String nickname,String pwd){
				Connection con=DBUtil.getCon();
				String sql = "insert into d_user(email,nickname,password) values(?,?,?)";
				try {
					PreparedStatement prep=con.prepareStatement(sql);//预编译
					prep.setString(1,email);
					prep.setString(2,nickname);
					prep.setString(3,pwd) ;
					prep.executeUpdate();//插入，删除，修改
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	//定义一个方法	---根据Email从d_user表中查询数据
	//该方法返回值boolean的值，如果返回值为true，表示能查询出来，邮箱不能被注册
	//如果返回值为false，表示查询不出来，邮箱可以注册
	public static boolean getUserByEmail(String email) {
		Connection con = DBUtil.getCon();
		String sql="select * from d_user where email=?";
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, email);
			ResultSet rs = prep.executeQuery();
			if(rs.next()){	//能查询出结果集
				return true;
			}else{	//不能查询出结果集
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
