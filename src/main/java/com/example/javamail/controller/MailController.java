package com.example.javamail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    JavaMailSender mailSender;

    @ResponseBody
    @RequestMapping("/send")
    public Object sendEmail() {

        try {

            logger.trace("trance");
            logger.debug("debug");
            logger.info("info");
            logger.warn("warn");
            logger.error("error");

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("1445101933@qq.com");
            message.setTo("1445101933@qq.com");
            message.setSubject("测试邮件主题");
            message.setText("测试邮件内容");
            mailSender.send(message);
            return "sucesss";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "error";
        }
    }
}
