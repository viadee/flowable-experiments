import de.viadee.bpm.entity.Species;
import de.viadee.bpm.services.StarWarsApi;
import org.junit.Test;

import java.util.List;


public class ServiceTest {


    @Test
    public void serviceTest(){
        StarWarsApi api = new StarWarsApi();
        List<Species> species = api.getSpecies();

        api.getPersonsForSpecies(species.get(0));
        System.out.println(api.getPersonCountForSpecies(species.get(0)));

    }
}
