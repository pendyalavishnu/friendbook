package com.example.friendbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {
    @Autowired
    private TemplateEngine template_engine;

    String build(String message){
        Context context = new Context();
        context.setVariable("message", message);
        return template_engine.process("mailTemplate", context);
    }
}
