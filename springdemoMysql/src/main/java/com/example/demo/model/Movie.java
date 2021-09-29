package com.example.demo.model;

public class Movie implements Comparable<Movie> {
    private int id;
    private String title;
    private int year;
    private int length;
    private String subject;
    private int popularity;
    private String awards;

    public Movie(int id, String title, int year, int length, String subject, int popularity, String awards) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.length = length;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", length=" + length +
                ", subject='" + subject + '\'' +
                ", popularity=" + popularity +
                ", awards='" + awards + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    @Override
    public int compareTo(Movie o) {
        return o.getPopularity() - this.popularity;
    }
}
