import domain.Tema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import repository.TemaXMLRepo;
import service.Service;
import validation.TemaValidator;
import validation.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

@Tag("TemaTest")
class TemaValidationTest {

    private TemaXMLRepo temaRepo;
    private TemaValidator temaValidator;
    private Service service;

    @BeforeEach
    void setUp() {
        temaRepo = new TemaXMLRepo("C:\\Users\\Bianca\\Desktop\\VVSS_JenkEnvir\\Lab2\\Lab1VVSS2\\Teme.xml");  // make sure this file exists
        temaValidator = new TemaValidator();
        service = new Service(null, null, temaRepo, temaValidator, null, null);
    }

    @Test
    void testAddValidTema() {
        Tema tema = new Tema("100", "Tema la map", 10, 8);

        Tema existing = service.findTema("100");
        if (existing != null) {
            service.deleteTema("100"); // clean up before test
        }

        Tema result = service.addTema(tema);
        assertNull(result);
    }

    @Test
    void testAddInvalidTema_EmptyDescription() {
        Tema tema = new Tema("101", "", 10, 8);
        assertThrows(ValidationException.class, () -> service.addTema(tema));
    }
}
