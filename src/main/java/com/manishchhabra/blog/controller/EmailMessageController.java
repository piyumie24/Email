package com.manishchhabra.blog.controller;

import com.manishchhabra.blog.email.EmailSender;
import com.manishchhabra.blog.model.EmailMessage;
import com.manishchhabra.blog.service.EmailMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
//@RequestMapping(value = "/email")
public class EmailMessageController {

    @Autowired
    private EmailMessageService emailMessageService;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String getPersonList(ModelMap model) {
        model.addAttribute("listEmailMessage", emailMessageService.listEmailMessage());
        return "output";
    }




    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("emailConfiguration.xml");
    EmailSender emailSender=(EmailSender)context.getBean("emailSenderBean");


    final static Logger logger = LoggerFactory.getLogger(EmailMessageController.class);


    @RequestMapping(value="/emailForm",method= RequestMethod.GET)
    public ModelAndView displayEmailForm(Map<String, Object> map){

        logger.debug(" setting up the Email form ");

        ModelAndView view=new ModelAndView("EmailFormView");

        //setting up the  required parameter value in the request scope for CommandName parameter
        map.put("email", new EmailMessage());

        return view;

    }


    @RequestMapping(value="/sendEmail",method= RequestMethod.POST)
    public ModelAndView sendEmailUsingGmail(@ModelAttribute("email")EmailMessage email) throws MailException {


        logger.debug(" ********************* ready to send the email **********************");
        logger.debug(" receiver email address [{}]", email.getEmail());
        logger.debug(" email subject [{}]", email.getName());
        logger.debug(" email body [{}]", email.getMessage());

        ModelAndView view=new ModelAndView("EmailView");

        view.addObject("emailAddress",email.getMessage());
        emailSender.sendEmail(email);
        logger.debug(" ********************* email was sent **********************");

        return view;

    }

}
