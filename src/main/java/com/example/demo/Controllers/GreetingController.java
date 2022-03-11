package com.example.demo.Controllers;

import com.example.demo.domain.Message;
import com.example.demo.repos.MessageRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
    public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;
        @GetMapping
    public String main(@NotNull Map<String, Object> model ){
       Iterable<Message> messages = messageRepo.findAll();
            model.put("messages", messages);

            return "main";
        }
    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        System.out.println(message.getText());

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }
    }
