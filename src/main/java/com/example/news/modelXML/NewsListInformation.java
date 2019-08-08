package com.example.news.modelXML;

import java.util.List;

public class NewsListInformation {

    public String ClubName;
    public String ClubWebsiteURL;
    public List<NewsletterNewsItem> NewsletterNewsItems;


    @Override
    public String toString() {
        return "NewsListInformation{" +
                "ClubName=" + ClubName +
                ", ClubWebsiteURL='" + ClubWebsiteURL +
                ", NewsletterNewsItems=" + NewsletterNewsItems;
    }

}
