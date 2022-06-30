package controllerTest;

import com.bolsadeideas.springboot.web.app.controllers.MagnetoController;
import com.bolsadeideas.springboot.web.app.models.Adn;
import com.bolsadeideas.springboot.web.app.models.Candidate;
import com.bolsadeideas.springboot.web.app.models.Statistics;
import com.bolsadeideas.springboot.web.app.service.IadnService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MagnetoControllerTest {

    private static Integer CANTIDAD_HUMANO = 1;
    private static Integer CANTIDAD_MUTANTE = 1;

    private static String[] CADENA_MUTANTE = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
    private static String[] CADENA_HUMANO = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};

    private static String IS_MUTANTE = "YES";
    private static String NOT_MUTANTE = "NO";


    @Mock
    private IadnService adnService;

    @InjectMocks
    MagnetoController magnetoController;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void mutantTest() {
        Candidate mutante = new Candidate();
        mutante.setDna(CADENA_MUTANTE);
        Candidate humano = new Candidate();
        humano.setDna(CADENA_HUMANO);
        final Adn adn_humano = new Adn(Arrays.toString(humano.getDna()), NOT_MUTANTE);
        final Adn adn_mutante = new Adn(Arrays.toString(mutante.getDna()), IS_MUTANTE);
        final ResponseEntity<String> responseMutante = magnetoController.mutant(mutante);
        final ResponseEntity<String> responseHumano = magnetoController.mutant(humano);
        assertNotNull(responseMutante);
        assertNotNull(responseHumano);
        assertEquals(responseMutante.getStatusCode().value(),200 );
        assertEquals(responseHumano.getStatusCode().value(),403);
    }



    @Test
    public void allAdnsTest() {
        final Adn ADN = new Adn();
        Mockito.when(adnService.findAll()).thenReturn(Arrays.asList(ADN));
        final ResponseEntity<List<Adn>> responseController = magnetoController.allAdns();
        assertNotNull(responseController);
        assertFalse(responseController.getBody().isEmpty());
        assertEquals(responseController.getBody().size(), 1);
    }


    @Test
    public void statsTest() {
        Candidate mutante = new Candidate();
        mutante.setDna(CADENA_MUTANTE);
        Candidate humano = new Candidate();
        humano.setDna(CADENA_HUMANO);
        List<Adn> listAdn = new ArrayList<>();
        final Adn adn_humano = new Adn(Arrays.toString(humano.getDna()), NOT_MUTANTE);
        final Adn adn_mutante = new Adn(Arrays.toString(mutante.getDna()), IS_MUTANTE);
        listAdn.add(adn_mutante);
        listAdn.add(adn_humano);
        Mockito.when(adnService.findAll()).thenReturn(listAdn);
        final ResponseEntity<Statistics> response = magnetoController.stats();
        assertNotNull(response);
        assertTrue(response.getBody().getCount_mutant_dna().equals(CANTIDAD_MUTANTE));
        assertTrue(response.getBody().getCount_mutant_dna().equals(CANTIDAD_HUMANO));

    }


}
