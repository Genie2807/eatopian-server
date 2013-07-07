package com.eatopian.entity;

import java.util.Date;

public class DishImage {
	
	private User author;
	private Date uploadDateTime;
	private String filename;
	private byte[] sourceData;
	
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Date getUploadDateTime() {
		return uploadDateTime;
	}
	public void setUploadDateTime(Date uploadDateTime) {
		this.uploadDateTime = uploadDateTime;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getSourceData() {
		return sourceData;
	}
	public void setSourceData(byte[] sourceData) {
		this.sourceData = sourceData;
	}

}
