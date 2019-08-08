package com.example.news.service;

import com.example.news.exception.NewsArticleNotFoundException;
import com.example.news.modelMongoDB.NewsletterNewsItems;
import com.example.news.repository.NewsletterNewsItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NewsletterNewsItemsService {

    @Autowired
    NewsletterNewsItemsRepo repository;


    public Iterable<NewsletterNewsItems> findAllNews(){

        return repository.findAll();
    }


    public NewsletterNewsItems findNewsById(Long id){

        Optional<NewsletterNewsItems> optional = repository.findBy_id(id);

        return optional.orElseThrow(() -> new NewsArticleNotFoundException("Couldn't find a news article with id: " + id));

    }

}


