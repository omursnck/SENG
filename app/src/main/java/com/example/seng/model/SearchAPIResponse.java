package com.example.seng.model;

import java.util.List;

public class SearchAPIResponse {
    List<SearchArrayObjects> Title  = null;
    List<SearchArrayObjects> Rating  = null;
    List<SearchArrayObjects> Genres  = null;
    List<SearchArrayObjects> Director_names  = null;
    List<SearchArrayObjects> Description  = null;
    List<SearchArrayObjects> Actors  = null;
    List<SearchArrayObjects> Image  = null;
    List<SearchArrayObjects> ID  = null;

    public List<SearchArrayObjects> getID() {
        return ID;
    }

    public void setID(List<SearchArrayObjects> ID) {
        this.ID = ID;
    }

    public List<SearchArrayObjects> getTitle() {
        return Title;
    }

    public void setTitle(List<SearchArrayObjects> title) {
        Title = title;
    }

    public List<SearchArrayObjects> getRating() {
        return Rating;
    }

    public void setRating(List<SearchArrayObjects> rating) {
        Rating = rating;
    }

    public List<SearchArrayObjects> getGenres() {
        return Genres;
    }

    public void setGenres(List<SearchArrayObjects> genres) {
        Genres = genres;
    }

    public List<SearchArrayObjects> getDirector_names() {
        return Director_names;
    }

    public void setDirector_names(List<SearchArrayObjects> director_names) {
        Director_names = director_names;
    }

    public List<SearchArrayObjects> getDescription() {
        return Description;
    }

    public void setDescription(List<SearchArrayObjects> description) {
        Description = description;
    }

    public List<SearchArrayObjects> getActors() {
        return Actors;
    }

    public void setActors(List<SearchArrayObjects> actors) {
        Actors = actors;
    }

    public List<SearchArrayObjects> getImage() {
        return Image;
    }

    public void setImage(List<SearchArrayObjects> image) {
        Image = image;
    }
}
