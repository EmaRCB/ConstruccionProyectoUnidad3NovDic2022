package Codigo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JSONReader {
    public boolean readJSON(){
        JSONParser parser = new JSONParser();
        String id;
        String firstName;
        String lastName;
        String photo;

        try (Reader reader = new FileReader("./Lib/actores.json")){
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            JSONObject employees = (JSONObject) jsonObject.get("employees");

            JSONArray employee = (JSONArray) employees.get("employee");
            
            JSONObject employeeObj;
            for (int i = 0; i < employee.size(); i++) {
                employeeObj = (JSONObject) employee.get(i);
                id = (String) employeeObj.get("id");
                firstName = (String) employeeObj.get("firstName");
                lastName = (String) employeeObj.get("lastName");
                photo = (String) employeeObj.get("photo");
            }

            return true;

        } catch (FileNotFoundException e){
            e.printStackTrace();
            return false;
        } catch (IOException e){
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
