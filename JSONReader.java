import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class JSONReader {
    
    EmpleadoManager empManager = new EmpleadoManager();

    public void readJson() throws Exception{
        if (JSONExists() & validateJSON()){
            System.out.println("Aquí comienza el proceso de la entrega 2");
            convertJSONToObjects();
            VistaListado nuevaVentana = new VistaListado();
            nuevaVentana.mostrarDatos(empManager.getAllContacts());
            System.out.println();
            

        }
    }


    public boolean JSONExists() {
        String pathfile = "actores.json";
        File file = new File(pathfile);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateJSON(){
        String pathfile = "actores.json";
        JSONObject employees = new JSONObject();
        JSONParser parser = new JSONParser();
        

        try(Reader reader = new FileReader(pathfile)){
            //
            JSONObject jsonObject = (JSONObject)parser.parse(reader);

            
            //Verifico la existencia de employees
            employees = (JSONObject) jsonObject.get("employees");

            //Obtengo en un array a todos los empleados
            JSONArray employee = (JSONArray)employees.get("employee");
            
            //
            JSONObject employeeId;
            String id, firstName, lastName, photo;
            for (int i = 0; i < employee.size(); i++) {
                employeeId = (JSONObject) employee.get(i);

                id = (String) employeeId.get("id");
                firstName = (String) employeeId.get("firstName");
                lastName = (String) employeeId.get("lastName");
                photo = (String) employeeId.get("photo");
                
                if(id == null || firstName == null || lastName == null || photo == null){
                    throw new Exception("Formato de archivo JSON incorrecto");
                }


            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return false;
        }catch(NullPointerException e){
            e.printStackTrace();
            return false;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }catch(ParseException e){
            e.printStackTrace();
            return false;
        }catch(Error e){
            System.out.println("Formato de archivo JSON incorrecto");
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public void convertJSONToObjects() throws Exception{
        String pathfile = "actores.json";
        JSONObject employees = new JSONObject();
        JSONParser parser = new JSONParser();
        

        try(Reader reader = new FileReader(pathfile)){
            //
            JSONObject jsonObject = (JSONObject)parser.parse(reader);

            
            //Verifico la existencia de employees
            employees = (JSONObject) jsonObject.get("employees");

            //Obtengo en un array a todos los empleados
            JSONArray employee = (JSONArray)employees.get("employee");
            
            //
            JSONObject employeeId;
            String id, firstName, lastName, photo;
            for (int i = 0; i < employee.size(); i++) {
                employeeId = (JSONObject) employee.get(i);

                id = (String) employeeId.get("id");
                firstName = (String) employeeId.get("firstName");
                lastName = (String) employeeId.get("lastName");
                photo = (String) employeeId.get("photo");
                
                empManager.addContact(id, firstName, lastName, photo);

            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }


    



}