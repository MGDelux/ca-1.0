package facades;

import entities.Joke;
import utils.EMF_Creator;
import entities.SolidCode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadeExampleTest {

    private static EntityManagerFactory emf;
    private static Facadexxxxxxxxxxx facade;

    public FacadeExampleTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = Facadexxxxxxxxxxx.getFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("SolidCode.deleteAllRows").executeUpdate();
            em.createNamedQuery("Joke.deleteAllRows").executeUpdate();
            em.persist(new SolidCode("Mathias", "cph-mct123","Game Of Thrones"));
            em.persist(new SolidCode("Emil", "cph-ew45","Prison Break"));
            em.persist(new SolidCode("Søren", "cph-sa343","Broklynn Nine-Nine"));
            em.persist(new Joke("Hvad laver edderkoppen når den keder sig?","Den går på nettet"));
            em.persist(new Joke("Så hvordan kan får bedste lide at kommunikere?","Via mæææææææils."));
            em.persist(new Joke("Hvad hedder verdens fattigste konge?"," Kong Kurs"));
            em.persist(new Joke("Hvad sagde den ene skilt til den anden? Er du gift?","Nej, jeg er skilt!"));
            em.persist(new Joke("Hvor mange programmerere skal der til for at skifte en pære?","ingen, det er et hardwareproblem"));


            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testAFacadeMethod() {
        assertEquals(3, facade.getRenameMeCount(), "Expects two rows in the database");
    }
    

}
