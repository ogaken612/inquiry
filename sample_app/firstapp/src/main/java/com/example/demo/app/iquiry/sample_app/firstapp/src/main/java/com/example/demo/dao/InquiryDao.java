package com.example.demo.dao;

import java.util.List;

import entity.Inquiry;

public interface InquiryDao {
	
	void insertInquiry(Inquiry inquiry);
	
	int updateInquiry(Inquiry inquiry);
	
	List<Inquiry>getAll();

}
