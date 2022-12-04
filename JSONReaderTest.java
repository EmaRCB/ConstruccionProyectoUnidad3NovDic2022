import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONReaderTest {
    private static JSONReader jsonReader;

    @BeforeEach
    public void setUp(){
        System.out.println("Instanciando Contact Manager");
        jsonReader = new JSONReader();
    }

    @Test
    @DisplayName("Existe Json")
    public void ExisteJson(){
        /*ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("actores.json").getFile());
        assertTrue(file.exists());*/
        assertTrue(jsonReader.JSONExists());
    }

    @Test
    @DisplayName("Formato de Json Correcto")
    public void FormatoJsonCorrecto(){
        assertTrue(jsonReader.validateJson());
    }
}