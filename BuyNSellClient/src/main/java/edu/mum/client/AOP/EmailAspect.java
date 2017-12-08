package edu.mum.client.AOP;

import edu.mum.client.config.MailUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by prasannabajracharya on 8/15/17.
 */
@Component
@Aspect
public class EmailAspect
{
    @Autowired
    private MailUtil mailUtil;

    @After("execution(public void edu.mum.client.services.PostService.interestedEmail(..))")
    public void sendEmail(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String postId = (String)args[0];
        System.out.println("Sending email...");
        mailUtil.sendEmail("rabinshrestha677@gmail.com","prasanna.bajracharya@gmail.com",
                "Interested to buy product","I am interested to buy this product" + postId);
        System.out.println("End of EmailAspect.sendEmail()");
    }
}
