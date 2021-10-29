package de.viadee.bpm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class SpeciesList {

    private Species[] results;

    private String count;

    private String next;

    public Species[] getSpecies() {
        return results;
    }

    public void setSpecies(Species[] species) {
        this.results = species;
    }
}
