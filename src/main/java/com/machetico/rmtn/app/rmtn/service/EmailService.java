package com.machetico.rmtn.app.rmtn.service;

import com.machetico.rmtn.app.rmtn.utilities.EmailDetails;

public interface EmailService{
    public String sendSimpleMail(EmailDetails details);

    public String sendMailWithAttachment(EmailDetails details);

    
}