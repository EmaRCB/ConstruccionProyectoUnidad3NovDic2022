import java.io.File;

public class Main{
    public static void main(String[] args) {
        
        JSONReader jsonReader = new JSONReader();

        //Probar que el archivo JSON existe
        System.out.println(jsonReader.JSONExists());

    }
    
}