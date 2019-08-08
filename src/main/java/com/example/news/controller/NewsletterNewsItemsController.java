package com.example.news.controller;

import com.example.news.modelMongoDB.NewsletterNewsItems;
import com.example.news.service.NewsletterNewsItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/api")
public class NewsletterNewsItemsController {

    @Autowired
    NewsletterNewsItemsService service;


    @GetMapping(value="/provider/realise/v1/teams/t94/news",produces = "application/json")

    public Iterable<NewsletterNewsItems> getAllNews(){

        return service.findAllNews();
    }


    @GetMapping(value="/provider/realise/v1/teams/t94/news/{id}",produces = "application/json")
    public NewsletterNewsItems getNewsById(@PathVariable(value="id") Long id){

        return service.findNewsById(id);

    }

}
