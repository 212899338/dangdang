package com.tedu.bean;

import java.sql.Date;


//ͼ�����
public class Book {
	//����
	//id��
	public int id;
	//����
	public String productName;
	//��ļ��
	public String description;
	//�г��۸�
	public double fixedPrice;
	//�����۸�
	public double dangPrice;
	//���ͼƬ
	public String productpic;
	//����
	public String author;
	//���߼��
	public String authorsummary;
	//������
	public String publishing;
	//����ʱ��
	public Date publishTime;
	@Override
	//���book�����ʱ���Ը�toString��д�ķ�ʽ���
	public String toString() {
		return "Book [author=" + author + ", dangPrice=" + dangPrice
				+ ", description=" + description + ", fixedPrice=" + fixedPrice
				+ ", id=" + id + ", productName=" + productName
				+ ", productpic=" + productpic + ", publishTime=" + publishTime
				+ ", publishing=" + publishing + "]";
	}
}
