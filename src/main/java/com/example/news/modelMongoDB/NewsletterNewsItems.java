package com.example.news.modelMongoDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "news")
public class NewsletterNewsItems {

    @Id
    public Long _id;

    public String ClubName;
    public String ClubWebsiteURL;
    public String ArticleURL;
    public Long NewsArticleID;
    public String PublishDate;
    public String Taxonomies;
    public String TeaserText;
    public String ThumbnailImageURL;
    public String Title;
    public String OptaMatchId;


    
}
