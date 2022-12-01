import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

public class JSONModificationTest {
    private static JSONReader jsonReader;

    @BeforeEach
    public void setUp(){
        System.out.println("Instanciando Contact Manager");
        jsonReader = new JSONReader();
    }

    @Test
    @DisplayName("Modificación exitosa")
    public void modificacionJSON() throws Exception{
        ArrayList<Empleado> arrayEmpleados = new ArrayList<Empleado>();
        Empleado nuevoEmpleado = new Empleado("123", "Emanuel", "Chavez", "https://jsonformatter.org/img/tom-cruise.jpg");
        arrayEmpleados.add(nuevoEmpleado);
        jsonReader.createJSONFileFromArrayList(arrayEmpleados);

        /*
        ArrayList<Empleado> arrayEmpleados2 = new ArrayList<Empleado>();
        Empleado nuevoEmpleado2 = new Empleado("123", "Jamart", "Chavez", "https://jsonformatter.org/img/tom-cruise.jpg");
        arrayEmpleados2.add(nuevoEmpleado2);
        jsonReader.createJSONFileFromArrayList(arrayEmpleados2);*/
        
        jsonReader.convertJSONToObjects();

        ArrayList<Empleado> nuevoArray2 = new ArrayList<Empleado>();
        nuevoArray2 = jsonReader.empManager.getAllContacts();
        
        assertEquals("Jamart", nuevoArray2.get(0).getFirstName());


    }


    
    
}
