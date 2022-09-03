package ru.haulmont.application.entity;

import java.util.UUID;

public class ResponseBook {
    private UUID id;
    private String title;
    private String publishYear;
    private String manufacturer;

    public ResponseBook(UUID id, String title, String publishYear, String manufacturer) {
        this.id = id;
        this.title = title;
        this.publishYear = publishYear;
        this.manufacturer = manufacturer;
    }

    public ResponseBook(String title, String publishYear) {
        this.title = title;
        this.publishYear = publishYear;
    }

    public ResponseBook() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
