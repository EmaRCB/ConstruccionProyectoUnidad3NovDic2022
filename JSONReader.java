import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JSONReader {

    public boolean JSONExists(String pathfile) {
        File file = new File(pathfile);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public JSONObject readJSON(String pathfile){
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
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }catch(Error e){
            System.out.println("Formato de archivo JSON incorrecto");
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return employees;
    }

}