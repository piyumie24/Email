package com.manishchhabra.blog.service;

import com.manishchhabra.blog.model.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmailMessageService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "EmailMessageData";
	

	public List<EmailMessage> listEmailMessage() {
		return mongoTemplate.findAll(EmailMessage.class, COLLECTION_NAME);
	}
	
}
