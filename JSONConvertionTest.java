import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JSONConvertionTest {
    private static JSONReader jsonReader;
    private static EmpleadoManager empManager;


    @Test
    @DisplayName("All Contacts Exists")
    public void ContactsExist(){
        jsonReader = new JSONReader();
        empManager = new EmpleadoManager();
        assertNotNull(jsonReader.empManager.getAllContacts());
    }

    
    
}
