package com.codesch.afdolash.meetpoint.model;

/**
 * Created by Afdolash on 11/4/2017.
 */

public class Author {
    private String name, title, badge, image;
    private Double totalRate, totalLiker;

    public Author(String name, String title, String badge, String image, Double totalRate, Double totalLiker) {
        this.name = name;
        this.title = title;
        this.badge = badge;
        this.image = image;
        this.totalRate = totalRate;
        this.totalLiker = totalLiker;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getBadge() {
        return badge;
    }

    public String getImage() {
        return image;
    }

    public Double getTotalRate() {
        return totalRate;
    }

    public Double getTotalLiker() {
        return totalLiker;
    }
}
