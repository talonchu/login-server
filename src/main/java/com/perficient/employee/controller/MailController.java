package com.perficient.employee.controller;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
public class MailController {
	@Autowired
	JavaMailSenderImpl mailSender;

	@RequestMapping("sendemail")
	public void sendEmail() throws MessagingException {
		System.out.println(111111);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("hz2z1009@qq.com");
		message.setTo("talon.chu@perficient.com");
		message.setSubject("测试邮件主题");
		message.setText("测试邮件内容");
		mailSender.send(message);
	}
}
