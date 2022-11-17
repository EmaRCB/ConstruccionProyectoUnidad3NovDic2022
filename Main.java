import java.io.File;

public class Main {
    public static void main(String[] args) {

        JSONReader jsonReader = new JSONReader();

        // Probar que el formato del archivo JSON sea correcto
        jsonReader.readJSON("actores.json");

    }

}