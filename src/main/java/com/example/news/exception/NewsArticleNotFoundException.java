package com.example.news.exception;

public class NewsArticleNotFoundException extends RuntimeException {

    public NewsArticleNotFoundException(String s){

        super(s);
    }
}
