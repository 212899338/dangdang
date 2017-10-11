package com.tedu.bean;

import java.sql.Date;


//图书对象
public class Book {
	//特征
	//id号
	public int id;
	//书名
	public String productName;
	//书的简介
	public String description;
	//市场价格
	public double fixedPrice;
	//当当价格
	public double dangPrice;
	//书的图片
	public String productpic;
	//作者
	public String author;
	//作者简介
	public String authorsummary;
	//出版社
	public String publishing;
	//出版时间
	public Date publishTime;
	@Override
	//输出book对象的时候，以该toString重写的方式输出
	public String toString() {
		return "Book [author=" + author + ", dangPrice=" + dangPrice
				+ ", description=" + description + ", fixedPrice=" + fixedPrice
				+ ", id=" + id + ", productName=" + productName
				+ ", productpic=" + productpic + ", publishTime=" + publishTime
				+ ", publishing=" + publishing + "]";
	}
}
