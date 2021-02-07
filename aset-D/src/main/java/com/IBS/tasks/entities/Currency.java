package com.IBS.tasks.entities;


public enum Currency {
    EU ("EU"),
    USD ("USD"),
    RU ("RU");

    private String title;

    Currency(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
