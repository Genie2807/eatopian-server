package com.eatopian.entity;

//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Review {

	private User author;
	private ArrayList<Dish> dishTag;
	private String review;
	private Date datetime;
	
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public ArrayList<Dish> getDishTag() {
		return dishTag;
	}
	public void setDishTag(ArrayList<Dish> dishTag) {
		this.dishTag = dishTag;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
//	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
//    System.out.print(dateFormat.format(date));	
}
