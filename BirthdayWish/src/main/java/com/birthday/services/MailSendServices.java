package com.birthday.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.birthday.dao.FriendRepository;
import com.birthday.entity.Friend;

@Service
public class MailSendServices 
{
	@Autowired
	private JavaMailSender mailSender;
	private boolean sent=false; 
	
	@Autowired
	FriendRepository friendRepository;
	
	public List<Friend> GetFriends()
	{
		List<Friend> friends= friendRepository.findAll();
		
		return friends;
	}
		
	
	public boolean sendEmail(String toEmail,String subject,String body,String Name) 
	{
		SimpleMailMessage message= new SimpleMailMessage();
		message.setFrom("ashokpawar8020@gmail.com");
		message.setTo(toEmail);
		message.setText(body+" "+Name+"!");
		message.setSubject(subject);
		mailSender.send(message);
		sent=true;
		return sent;
	}
	
	public boolean sendRemainder(String toEmail,String subject,String body) 
	{
		SimpleMailMessage message= new SimpleMailMessage();
		message.setFrom("ashokpawar8020@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
		sent=true;
		return sent;
	}

}
