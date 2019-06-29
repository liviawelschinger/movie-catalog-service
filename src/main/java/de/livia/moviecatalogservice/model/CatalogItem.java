package de.livia.moviecatalogservice.model;

public class CatalogItem {

    // a movie has a title, a description and a rating
    private String title;
    private String desc;
    private int rating;


    // Constructor, so you can put data in (hardcode data)
    public CatalogItem(String title, String desc, int rating) {
        this.title = title;
        this.desc = desc;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
