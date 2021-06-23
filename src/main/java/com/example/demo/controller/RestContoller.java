package com.example.demo.controller;

import com.example.demo.model.FeedBack;
import com.example.demo.repository.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class RestContoller {

    @Autowired
    private FeedBackRepository feedBackRepository;

    @GetMapping("/")
    public String index(){
        return "hello";
    }

    // use postman or any browser plugin to test the endpoint
    @PostMapping("/")
    public String saveFeedBack(@RequestBody String feedback){
        FeedBack newFeedback = new FeedBack(feedback);
        feedBackRepository.save(newFeedback);
        return "saved";
    }
}
