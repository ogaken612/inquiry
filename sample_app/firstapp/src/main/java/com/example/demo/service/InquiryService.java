package com.example.demo.service;

import java.util.List;

import entity.Inquiry;

public interface InquiryService {
	
	void save(Inquiry inquiry);
	
	void update(Inquiry inquiry);
	
	List<Inquiry> getAll();

}
