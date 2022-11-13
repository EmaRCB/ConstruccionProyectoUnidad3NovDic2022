import java.io.File;
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

    public boolean JSONExists() {
        File file = new File("actores.json");
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

}
