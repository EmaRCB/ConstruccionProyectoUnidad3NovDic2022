import java.util.ArrayList;

public class EmpleadoManager {
    
    ArrayList<Empleado> empleados = new ArrayList<Empleado>();

    public void addContact(String id, String firstName, String lastName, String photo) {
        Empleado empleado = new Empleado(id, firstName, lastName, photo);
        validarEmpleado(empleado);
        empleados.add(empleado);
    }

    private void validarEmpleado(Empleado empleado) {
        empleado.validateID();
        empleado.validateFirstName();
        empleado.validateLastName();
        empleado.validatePhoto();
    }

    public ArrayList<String> idList(){
        ArrayList<String> idArray = new ArrayList<String>();
        ArrayList<Empleado> array = new ArrayList<Empleado>();
        array = getAllContacts();

        for (int i = 0; i < array.size(); i++) {
            idArray.add(array.get(i).getId());
        }

        return idArray;
    }

    public ArrayList<String> firstNameList(){
        ArrayList<String> firstNameArray = new ArrayList<String>();
        ArrayList<Empleado> array = new ArrayList<Empleado>();
        array = getAllContacts();

        for (int i = 0; i < array.size(); i++) {
            firstNameArray.add(array.get(i).getFirstName());
        }

        return firstNameArray;
    }

    public ArrayList<String> lastNameList(){
        ArrayList<String> lastNameArray = new ArrayList<String>();
        ArrayList<Empleado> array = new ArrayList<Empleado>();
        array = getAllContacts();

        for (int i = 0; i < array.size(); i++) {
            lastNameArray.add(array.get(i).getLastName());
        }

        return lastNameArray;
    }

    public ArrayList<String> photoList(){
        ArrayList<String> photoArray = new ArrayList<String>();
        ArrayList<Empleado> array = new ArrayList<Empleado>();
        array = getAllContacts();

        for (int i = 0; i < array.size(); i++) {
            photoArray.add(array.get(i).getPhoto());
        }

        return photoArray;
    }

    public ArrayList<Empleado> getAllContacts() {
        return empleados;
    }
}
