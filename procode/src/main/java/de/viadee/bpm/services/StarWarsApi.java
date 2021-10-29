package de.viadee.bpm.services;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.viadee.bpm.entity.Person;
import de.viadee.bpm.entity.Species;
import de.viadee.bpm.entity.SpeciesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StarWarsApi {

    private RestTemplate restTemplate = new RestTemplate();

    public List<Species> getSpecies(){
        String jsonString = restTemplate.getForObject("https://swapi.dev/api/species", String.class);
        JsonObject jsonObject = deserialize(jsonString);
        JsonArray results = jsonObject.getAsJsonArray("results");
        return getSpecies(results);
    }

    public List<Person> getPersonsForSpecies(Species species){
        List<Person> results = Lists.newArrayList();
        for(String peopleUrl : species.getPeople()){
            String jsonString = restTemplate.getForObject(peopleUrl, String.class);
            results.add(getPerson(jsonString));
        }
        return results;
    }

    public int getPersonCountForSpecies(Species species){
        return species.getPeople().size();
    }

    public JsonObject deserialize(String json) {
        Gson gson = new Gson();
        JsonObject jsonClass = gson.fromJson(json, JsonObject.class);
        return jsonClass;
    }

    public Person getPerson(String jsonPerson){
        Gson gson = new Gson();
        return gson.fromJson(jsonPerson,Person.class);
    }

    public List<Species> getSpecies(JsonArray array){
        List<Species> result = Lists.newArrayList();
        Gson gson = new Gson();
        for(JsonElement element : array){
            result.add(gson.fromJson(element, Species.class));
        }
        return result;
    }
}
