package de.viadee.bpm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Species {

    private String name;
    private String classification;
    private String designation;
    private String average_height;
    private String average_lifespan;
    private String eye_colors;
    private String hair_colors;
    private String skin_colors;
    private String language;
    private String homeworld;
    private List<String> people;
    private List<String> films;
    private String url;
    private String created;
    private String edited;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(final String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(final String designation) {
        this.designation = designation;
    }

    public String getAverage_height() {
        return average_height;
    }

    public void setAverage_height(final String average_height) {
        this.average_height = average_height;
    }

    public String getAverage_lifespan() {
        return average_lifespan;
    }

    public void setAverage_lifespan(final String average_lifespan) {
        this.average_lifespan = average_lifespan;
    }

    public String getEye_colors() {
        return eye_colors;
    }

    public void setEye_colors(final String eye_colors) {
        this.eye_colors = eye_colors;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public void setHair_colors(final String hair_colors) {
        this.hair_colors = hair_colors;
    }

    public String getSkin_colors() {
        return skin_colors;
    }

    public void setSkin_colors(final String skin_colors) {
        this.skin_colors = skin_colors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(final String homeworld) {
        this.homeworld = homeworld;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(final List<String> people) {
        this.people = people;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(final List<String> films) {
        this.films = films;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(final String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(final String edited) {
        this.edited = edited;
    }
}
