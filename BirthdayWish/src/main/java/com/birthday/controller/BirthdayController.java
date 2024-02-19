package com.birthday.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.birthday.entity.Friend;
import com.birthday.services.MailSendServices;

@Controller
public class BirthdayController 
{
	@Autowired
	MailSendServices sendServices;
	
	@GetMapping("/")
	@ResponseBody
	public String GetAllFriends() {
	    LocalDate date = LocalDate.now();
	    StringBuilder friendBuilder = new StringBuilder();
	    List<Friend> friends = sendServices.GetFriends();
	    List<Friend> birthdayBoys = new ArrayList<>();
	    List<Friend> remainingBoys = new ArrayList<>();

	    for (Friend friend : friends) {
	        LocalDate dateOfBirth = friend.getDateOfBirth();

	        
	        if (dateOfBirth.getMonth().equals(Month.FEBRUARY) && dateOfBirth.getDayOfMonth() == 29) {
	            if (date.getMonth().equals(Month.FEBRUARY) && date.getDayOfMonth() == 28) {
	                sendServices.sendEmail(friend.getEmail(), "Happy Birthday!", "Happy Birthday dear,", friend.getFirstName());
	                friendBuilder.append(friend.getFullName()).append(" , ");
	                birthdayBoys.add(friend);
	            }
	        } else if (dateOfBirth.getDayOfMonth() == date.getDayOfMonth() && dateOfBirth.getMonth() == date.getMonth()) {
	            sendServices.sendEmail(friend.getEmail(), "Happy Birthday!", "Happy Birthday dear,", friend.getFirstName());
	            friendBuilder.append(friend.getFullName()).append(" , ");
	            birthdayBoys.add(friend);
	        } else {
	            remainingBoys.add(friend);
	        }
	    }

	    String Names = friendBuilder.toString();
	    for (Friend friend : remainingBoys) {
	        sendServices.sendRemainder(friend.getEmail(), "Birthday Reminder!", " Today is " + Names + "'s Birthday . Don't forget to send a message !");
	    }

	    return "Mail sent successfully";
	}

}
