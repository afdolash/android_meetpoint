package com.codesch.afdolash.meetpoint.model;

/**
 * Created by Afdolash on 10/22/2017.
 */

public class Event {
    private String title, description, author, image, category;
    private String dateStart, timeStart, dateEnd, timeEnd;
    private Double longitude, latitude;

    public Event(String title, String description, String author, String image, String category, String dateStart, String timeStart, String dateEnd, String timeEnd, Double longitude, Double latitude) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.image = image;
        this.category = category;
        this.dateStart = dateStart;
        this.timeStart = timeStart;
        this.dateEnd = dateEnd;
        this.timeEnd = timeEnd;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
}
