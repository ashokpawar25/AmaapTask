package com.birthday.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import com.birthday.dao.FriendRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class MailSendServicesTest {

	@Mock
    private JavaMailSender mailSender;

    @Mock
    private FriendRepository friendRepository;

    @InjectMocks
    private MailSendServices mailSendServices;

    @Before(value = "")
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendEmail() {
        String toEmail = "ashokpawar25052001@gmail.com";
        String subject = "Mail for testing purpose";
        String body = "This mail is just sent for the testing birthday wish to ";
        String name = "Ashok";

        boolean sent = mailSendServices.sendEmail(toEmail, subject, body, name);

        assertTrue(!sent);

        verify(mailSender).send(any(SimpleMailMessage.class));
    }
    
    @Test
    public void testSendRemainder() {
    	String toEmail = "ashokpawar25052001@gmail.com";
        String subject = "Mail for testing purpose";
        String body = "This mail is just sent for the testing birthday wish to ";

        boolean sent = mailSendServices.sendRemainder(toEmail, subject, body);

        assertTrue(sent);

        verify(mailSender).send(any(SimpleMailMessage.class));
    }
}
