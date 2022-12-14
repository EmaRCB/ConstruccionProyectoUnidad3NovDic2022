public class Empleado {
    public String id;
    public String firstName;
    public String lastName;
    public String photo;

    public Empleado(String id, String firstName, String lastName, String photo){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



    @Override
    public String toString() {
        return "Empleado [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", photo=" + photo + "]";
    }

    
}
