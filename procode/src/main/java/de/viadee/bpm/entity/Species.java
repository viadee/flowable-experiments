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

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    private List<String> people;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<String> films;
    private String url;
    private String created;
    private String edited;

}
