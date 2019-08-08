package com.example.news.repository;

import com.example.news.modelMongoDB.NewsletterNewsItems;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface NewsletterNewsItemsRepo extends MongoRepository<NewsletterNewsItems,String> {


        Optional<NewsletterNewsItems> findBy_id(Long _id);

}
