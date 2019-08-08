package com.example.news.modelXML;

public class NewsletterNewsItem {


    public String ArticleURL;
    public Long NewsArticleID;
    public String PublishDate;
    public String Taxonomies;
    public String TeaserText;
    public String ThumbnailImageURL;
    public String Title;
    public String OptaMatchId;


    @Override
    public String toString() {
        return "NewsletterNewsItem{" +
                "ArticleURL='" + ArticleURL + '\'' +
                ", NewsArticleID=" + NewsArticleID +
                ", PublishDate='" + PublishDate + '\'' +
                ", Taxonomies='" + Taxonomies + '\'' +
                ", TeaserText='" + TeaserText + '\'' +
                ", ThumbnailImageURL='" + ThumbnailImageURL + '\'' +
                ", Title='" + Title + '\'' +
                ", OptaMatchId='" + OptaMatchId + '\'' +
                '}';
    }
}

