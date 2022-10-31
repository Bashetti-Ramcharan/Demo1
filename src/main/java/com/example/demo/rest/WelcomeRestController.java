package com.example.demo.rest;

import com.example.demo.configurations.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController
public class WelcomeRestController
{
    @Autowired
    private AppConfig config;

    @Autowired
    private Environment env;

      @GetMapping("/welcome")
    public  String welcomeMsg()
    {
        String port=env.getProperty("server.port");
        Map<String,String> msgs=config.getMessages();
        String msgValue=msgs.get("welcomeMsg");
        String greetValue=msgs.get("greetMsg");


        return msgValue+" server running on "+port+" "+greetValue;
    }
}
