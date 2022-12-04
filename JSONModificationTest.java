import org.json.simple.JSONObject;
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
        jsonReader.modifyEmployee(arrayEmpleados);


        ArrayList<Empleado> arrayEmpleados2 = new ArrayList<Empleado>();
        Empleado nuevoEmpleado2 = new Empleado("123", "Jamart", "Chavez", "https://jsonformatter.org/img/tom-cruise.jpg");
        arrayEmpleados2.add(nuevoEmpleado2);
        jsonReader.modifyEmployee(arrayEmpleados2);
        
        jsonReader.convertJSONToObjects();

        ArrayList<Empleado> nuevoArray2 = new ArrayList<Empleado>();
        nuevoArray2 = jsonReader.empManager.getAllContacts();
        
        assertEquals("Jamart", nuevoArray2.get(0).getFirstName());


    }

    @Test
    @DisplayName("Eliminación exitosa")
    public void eliminarEmpleado() throws Exception {

        /* OPCION 1 DE PRUEBA ESCRIBIENDO NUESTROS PROPIOS EMPLEADOS PARA UN ASSERTEQUALS CON EL STRING ESPECÍFICO DEL EMPLEADO QUE ELIMINAMOS
        ////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Empleado> arrayEmpleados = new ArrayList<Empleado>();
        Empleado nuevoEmpleado;
        nuevoEmpleado = new Empleado("0", "Emanuel", "Chavez", "https://jsonformatter.org/img/tom-cruise.jpg");
        arrayEmpleados.add(nuevoEmpleado);
        nuevoEmpleado = new Empleado("1", "Jamart", "Chavez", "https://jsonformatter.org/img/tom-cruise.jpg");
        arrayEmpleados.add(nuevoEmpleado);
        nuevoEmpleado = new Empleado("2", "Garci", "Chavez", "https://jsonformatter.org/img/tom-cruise.jpg");
        arrayEmpleados.add(nuevoEmpleado);
        jsonReader.modifyEmployee(arrayEmpleados);
        //////////////////////////////////////////////////////////////////////////////////////////////*/

        //OPCIÓN DOS DE PRUEBA CON LOS EMPLEADOS DEL JSON DE TRES ACTORES PARA UN ASSERTEQUALS DE ENTEROS DEL TOTAL DE EMPLEADOS EN EL JSON
        jsonReader.convertJSONToObjects();//se lee el json

        ArrayList<Empleado> nuevoArray = new ArrayList<Empleado>();
        nuevoArray = jsonReader.empManager.getAllContacts();//se crea un arraylist con los empleados del json

        int totalEmpleadosAntes = nuevoArray.size();//se cuentan los empleados
        jsonReader.deleteEmployee(nuevoArray, 1);//se elimina el empleado con el indice uno (trabajamos con indices por la vista enlistada)

        jsonReader.convertJSONToObjects();//se lee de nuevo el json con el empleado eliminado
        nuevoArray= jsonReader.empManager.getAllContacts();//se crea un arraylist con los empleados del json
        int totalEmpleadosDespues = nuevoArray.size();//se cuentan los empleados

        assertEquals(totalEmpleadosAntes, totalEmpleadosDespues + 1);//la pruba no debe ser exitosa a menos que se le sume +1 a la segunda variable

        //Si se usa la opción 1 de prueba se descomentan las lineas: 50-58 y 78 y se comenta la línea 74

        //assertEquals("Jamart", nuevoArray.get(1).getFirstName());//La prueba será éxitosa cuando se comente la linea de eliminación (68) y será fallida si se elimina el empleado

    }


    
    
}
