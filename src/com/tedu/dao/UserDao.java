package com.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tedu.util.DBUtil;
		//ģ�Ͳ�
		//�� UserDao��Ҫ��װ��d_user��Ĳ���
public class UserDao {
			//��װһ������  -- �����ύ�����ݲ��뵽d_user����
	public static void regist(String email,String nickname,String pwd){
				Connection con=DBUtil.getCon();
				String sql = "insert into d_user(email,nickname,password) values(?,?,?)";
				try {
					PreparedStatement prep=con.prepareStatement(sql);//Ԥ����
					prep.setString(1,email);
					prep.setString(2,nickname);
					prep.setString(3,pwd) ;
					prep.executeUpdate();//���룬ɾ�����޸�
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	//����һ������	---����Email��d_user���в�ѯ����
	//�÷�������ֵboolean��ֵ���������ֵΪtrue����ʾ�ܲ�ѯ���������䲻�ܱ�ע��
	//�������ֵΪfalse����ʾ��ѯ���������������ע��
	public static boolean getUserByEmail(String email) {
		Connection con = DBUtil.getCon();
		String sql="select * from d_user where email=?";
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, email);
			ResultSet rs = prep.executeQuery();
			if(rs.next()){	//�ܲ�ѯ�������
				return true;
			}else{	//���ܲ�ѯ�������
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
