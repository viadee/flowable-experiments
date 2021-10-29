import de.viadee.bpm.services.StarWarsApi;
import org.junit.Test;


public class ServiceTest {


    @Test
    public void serviceTest(){
        StarWarsApi api = new StarWarsApi();
        api.getSpecies();
    }
}
