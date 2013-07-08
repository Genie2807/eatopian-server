package com.eatopian.entity;

//import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

public class Review {

	private Account author;
	private List<Dish> dishTag;
	private String review;
	private Date datetime;
	
	public Account getAuthor() {
		return author;
	}
	public void setAuthor(Account author) {
		this.author = author;
	}
	public List<Dish> getDishTag() {
		return dishTag;
	}
	public void setDishTag(List<Dish> dishTag) {
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
