package com.example.news.xmlparsesave;

import com.example.news.modelXML.NewsListInformation;
import com.example.news.modelXML.NewsletterNewsItem;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class XmlToJsonParserSave {

    @Scheduled(fixedRate = 300000) //runs this scheduled method every 5 minutes
    public void getParseConvert() throws IOException {

        System.out.println("\n");

        // http GET resource url using Rest Template
        String url = "https://www.brentfordfc.com/api/incrowd/getnewlistinformation?count=3";


        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders header = new HttpHeaders();

        header.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        HttpEntity<String> entity = new HttpEntity<>(header);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);


        // mapping GET response to NewsListInformation class using Jackson
        XmlMapper mapper = new XmlMapper();
        NewsListInformation newsListInformation = mapper.readValue(responseEntity.getBody(), NewsListInformation.class);

        System.out.println(newsListInformation);


        //convert each object from NewsletterNewsItem to JSON
        List<BasicDBObject> objects = new ArrayList<>();
        Gson gson = new Gson();


        for(NewsletterNewsItem newsItem: newsListInformation.NewsletterNewsItems){

            BasicDBObject parse = BasicDBObject.parse(gson.toJson(newsItem));

            //replace ObjectId with NewsArticleID for duplicate articles to not be saving in DB
            parse.put("_id", newsItem.NewsArticleID);

            parse.put("ClubName", newsListInformation.ClubName);
            parse.put("ClubWebsiteURL", newsListInformation.ClubWebsiteURL);
            objects.add(parse);
        }

        saveToMongoDB(objects);
    }

    private void saveToMongoDB(List<BasicDBObject> objects){

        Mongo mongo = new Mongo("localhost", 27017);
        DB db = mongo.getDB("local");
        DBCollection dbCollection=db.getCollection("news");
        for(BasicDBObject dbo: objects){
            dbCollection.save(dbo);
        }
    }

}
