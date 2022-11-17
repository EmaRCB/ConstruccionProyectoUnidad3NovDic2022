import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JSONReader {

    public void readJson(){
        if (JSONExists() && validateJson()){
            System.out.println("Aquí comienza el proceso de la entraga 2");
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

    public boolean validateJson(){
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

                //System.out.println(id + " " + firstName + " " + lastName + " " + photo);
            }
        }catch(FileNotFoundException e){
            return false;
        }catch(NullPointerException e){
            return false;
        }catch(IOException e){
            return false;
        }catch(ParseException e){
            return false;
        }catch(Error e){
            System.out.println("Formato de archivo JSON incorrecto");
            return false;
        }catch(Exception e){
            return false;
        }
        
        return true;
    }


}