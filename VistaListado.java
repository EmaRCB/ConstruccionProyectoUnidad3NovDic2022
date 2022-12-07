import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class VistaListado extends JFrame {

    private JPanel panel;
    private JTable tablaEmpleados;
    private JScrollPane scrollPane;
    private ArrayList<Empleado> arrayEmpleados;
    private JSONReader jsonReader;

    public VistaListado(JSONReader jsonReader) throws IOException {
        this.jsonReader = jsonReader;
        iniciarComponentes();
        /*
        ArrayList<Empleado> arrayEmpleados = new ArrayList<Empleado>();
        Empleado nuevoEmpleado = new Empleado ("123", "Emanuel", "Bagundo", "https://jsonformatter.org/img/tom-cruise.jpg");
        arrayEmpleados.add(nuevoEmpleado);
        nuevoEmpleado = new Empleado ("123", "Emanuel", "Bagundo", "https://jsonformatter.org/img/tom-cruise.jpg");
        arrayEmpleados.add(nuevoEmpleado);

        mostrarDatos(arrayEmpleados);

         */

    }
    public void iniciarComponentes(){
        JFrame ventanaListaEmpleados = new JFrame();
        panel = new JPanel();
        tablaEmpleados = new JTable();
        scrollPane = new JScrollPane();

        ventanaListaEmpleados.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventanaListaEmpleados.setVisible(true);
        ventanaListaEmpleados.setSize(1015, 776);
        ventanaListaEmpleados.setLocationRelativeTo(null);
        Color colorComponentes2 = new Color(142, 183, 247);

        panel.setBounds(0, 0, 1000, 750);
        panel.setBackground(new Color(216, 191, 216));
        panel.setLayout(null);
        ventanaListaEmpleados.getContentPane().add(panel);

        scrollPane.setBounds(20, 20, 1000, 560);
        panel.add(scrollPane);

        JButton botonAgregar = new JButton("ADD NEW EMPLOYEE");
        botonAgregar.setBackground(colorComponentes2);
        botonAgregar.setBounds(580, 530, 210, 50);
        botonAgregar.setForeground(Color.white);
        botonAgregar.setFont(new Font("Cousine", 1, 16));
        panel.add(botonAgregar);

        JButton botonModificar = new JButton("MODIFY INFO");
        botonModificar.setBackground(colorComponentes2);
        botonModificar.setBounds(800, 530, 180, 50);
        botonModificar.setForeground(Color.white);
        botonModificar.setFont(new Font("Cousine", 1, 17));
        panel.add(botonModificar);


        JLabel mensajeAlerta = new JLabel("SELECT A ROW FROM THE TABLE TO MODIFY EMPLOYEE");
        mensajeAlerta.setFont(new Font("Cousine", 3,16));
        mensajeAlerta.setBounds(50, 530, 500, 50);
        //mensajeAlerta.setOpaque(true);
        mensajeAlerta.setHorizontalAlignment(SwingConstants.CENTER);
        mensajeAlerta.setVisible(false);
        panel.add(mensajeAlerta);

        JLabel textoID = new JLabel("ID:");
        textoID.setFont(new Font("Cousine", 1, 18));
        textoID.setBounds(20, 590, 35, 40);
        //textoID.setOpaque(true);
        JTextField campoID = new JTextField();
        campoID.setBounds(60, 590, 145, 40);
        campoID.setFont(new Font("Cousine", 3, 20));
        campoID.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(textoID);
        panel.add(campoID);
        textoID.setVisible(false);
        campoID.setVisible(false);

        JLabel firstName = new JLabel("First Name:");
        firstName.setFont(new Font("Cousine", 1, 18));
        firstName.setBounds(270, 590, 110, 40);
        //firstName.setOpaque(true);
        JTextField campoFN = new JTextField();
        campoFN.setBounds(390, 590, 180, 40);
        campoFN.setFont(new Font("Cousine", 3, 20));
        campoFN.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(firstName);
        panel.add(campoFN);
        firstName.setVisible(false);
        campoFN.setVisible(false);

        JLabel lastName = new JLabel("Last Name:");
        lastName.setFont(new Font("Cousine", 1, 18));
        lastName.setBounds(620, 590, 110, 40);
        //lastName.setOpaque(true);
        JTextField campoLN = new JTextField();
        campoLN.setBounds(740, 590, 240, 40);
        campoLN.setFont(new Font("Cousine", 3, 20));
        campoLN.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(lastName);
        panel.add(campoLN);
        lastName.setVisible(false);
        campoLN.setVisible(false);

        JLabel urlFoto = new JLabel("Photo from URL:");
        urlFoto.setFont(new Font("Cousine", 1, 18));
        urlFoto.setBounds(20, 640, 150, 40);
        //urlFoto.setOpaque(true);
        JTextField campoURL = new JTextField();
        campoURL.setBounds(180, 640, 540, 40);
        campoURL.setFont(new Font("Cousine", 3, 20));
        campoURL.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(urlFoto);
        panel.add(campoURL);
        urlFoto.setVisible(false);
        campoURL.setVisible(false);

        JButton botonGuardar = new JButton("SAVE");
        botonGuardar.setBackground(colorComponentes2);
        botonGuardar.setBounds(740, 640, 240, 40);
        botonGuardar.setForeground(Color.white);
        botonGuardar.setFont(new Font("Cousine", 1, 20));
        panel.add(botonGuardar);
        botonGuardar.setVisible(false);

        JButton botonGuardar2 = new JButton("SAVE");
        botonGuardar2.setBackground(colorComponentes2);
        botonGuardar2.setBounds(740, 640, 240, 40);
        botonGuardar2.setForeground(Color.white);
        botonGuardar2.setFont(new Font("Cousine", 1, 20));
        panel.add(botonGuardar2);
        botonGuardar2.setVisible(false);

        JButton botonEliminar = new JButton("DELETE EMPLOYEE PERMANENTLY");
        botonEliminar.setBackground(new Color(255, 94, 109));
        botonEliminar.setBounds(305, 690, 400, 35);
        botonEliminar.setForeground(Color.white);
        botonEliminar.setFont(new Font("Cousine", 1, 20));
        panel.add(botonEliminar);
        botonEliminar.setVisible(false);





        ActionListener modificarEmp = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tablaEmpleados.getSelectedRow() == -1){
                    mensajeAlerta.setVisible(true);
                    mensajeAlerta.setText("SELECT A ROW FROM THE TABLE TO MODIFY EMPLOYEE");
                    textoID.setVisible(false);
                    campoID.setVisible(false);
                    firstName.setVisible(false);
                    campoFN.setVisible(false);
                    lastName.setVisible(false);
                    campoLN.setVisible(false);
                    urlFoto.setVisible(false);
                    campoURL.setVisible(false);
                    botonGuardar.setVisible(false);
                    botonGuardar2.setVisible(false);
                    botonEliminar.setVisible(false);
                }
                else{
                    mensajeAlerta.setText("MODIFYING EMPLOYEE'S INFO");
                    mensajeAlerta.setVisible(true);
                    textoID.setVisible(true);
                    campoID.setVisible(true);
                    firstName.setVisible(true);
                    campoFN.setVisible(true);
                    lastName.setVisible(true);
                    campoLN.setVisible(true);
                    urlFoto.setVisible(true);
                    campoURL.setVisible(true);
                    botonGuardar.setVisible(true);
                    botonGuardar2.setVisible(false);
                    botonEliminar.setVisible(true);

                }
            }
        };
        botonModificar.addActionListener(modificarEmp);

        ActionListener agregarEmp = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mensajeAlerta.setText("ADDING NEW EMPLOYEE");
                mensajeAlerta.setVisible(true);
                textoID.setVisible(true);
                campoID.setVisible(true);
                firstName.setVisible(true);
                campoFN.setVisible(true);
                lastName.setVisible(true);
                campoLN.setVisible(true);
                urlFoto.setVisible(true);
                campoURL.setVisible(true);
                botonGuardar.setVisible(false);
                botonGuardar2.setVisible(true);
                botonEliminar.setVisible(false);
            }
        };
        botonAgregar.addActionListener(agregarEmp);

        ActionListener guardarInfo = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                if(campoID.getText().isEmpty() || campoFN.getText().isEmpty() || campoLN.getText().isEmpty() || campoURL.getText().isEmpty()){
                    mensajeAlerta.setText("FILL ALL THE TEXT FIELDS TO SAVE THE NEW INFO");
                    mensajeAlerta.setVisible(true);
                }
                else{
                    mensajeAlerta.setVisible(false);
                    int indiceEmpleado = tablaEmpleados.getSelectedRow();
                    String nuevoID = campoID.getText();
                    String nuevoFN = campoFN.getText();
                    String nuevoLN = campoLN.getText();
                    String nuevoURL = campoURL.getText();

                    arrayEmpleados.get(indiceEmpleado).setId(nuevoID);
                    arrayEmpleados.get(indiceEmpleado).setFirstName(nuevoFN);
                    arrayEmpleados.get(indiceEmpleado).setLastName(nuevoLN);
                    arrayEmpleados.get(indiceEmpleado).setPhoto(nuevoURL);

                    jsonReader.modifyEmployee(arrayEmpleados);
                    try {
                        mostrarDatos(arrayEmpleados);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                }
            }
        };
        botonGuardar.addActionListener(guardarInfo);

        ActionListener guardarInfoNueva = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("good");
                if(campoID.getText().isEmpty() || campoFN.getText().isEmpty() || campoLN.getText().isEmpty() || campoURL.getText().isEmpty()){
                    mensajeAlerta.setText("FILL ALL THE TEXT FIELDS TO SAVE THE NEW EMPLOYEE");
                    mensajeAlerta.setVisible(true);
                }
                else{
                    mensajeAlerta.setVisible(false);
                    String nuevoID = campoID.getText();
                    String nuevoFN = campoFN.getText();
                    String nuevoLN = campoLN.getText();
                    String nuevoURL = campoURL.getText();
                    Empleado nuevoEmpleado = new Empleado(nuevoID, nuevoFN, nuevoLN, nuevoURL);
                    arrayEmpleados.add(nuevoEmpleado);
                    jsonReader.addEmployee(arrayEmpleados);
                    try {
                        mostrarDatos(arrayEmpleados);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                }
            }
        };
        botonGuardar2.addActionListener(guardarInfoNueva);

        ActionListener eliminarEmp = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the employee selected permanently?",
                        "DELETE EMPLOYEE", JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if(opcion == 0){
                    mensajeAlerta.setVisible(false);
                    int indiceEmpleado = tablaEmpleados.getSelectedRow();
                    jsonReader.deleteEmployee(arrayEmpleados, indiceEmpleado);

                    try {
                        mostrarDatos(arrayEmpleados);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        botonEliminar.addActionListener(eliminarEmp);

    }

    //
    public void mostrarDatos(ArrayList<Empleado> arrayEmpleados) throws IOException {
        this.arrayEmpleados = arrayEmpleados;
        System.out.println(arrayEmpleados);
        scrollPane.setBounds(20, 20, 960, 500);
        panel.add(scrollPane);

        tablaEmpleados.setBackground(new Color(224, 255, 255));
        scrollPane.getViewport().add(tablaEmpleados);
        tablaEmpleados.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 43));
        tablaEmpleados.setFont(new Font("Serif", Font.BOLD, 20));
        tablaEmpleados.setRowHeight(260);

        //Vista temporal de las columnas de la lista
        String[] nombreColumnas = {"ID","First Name", "Last Name", "Photo"};
        //DefaultTableModel modeloTabla = (DefaultTableModel)tablaEmpleados.getModel();
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override //Redefinimos el método getColumnClass
            public Class getColumnClass(int column){
                switch(column) {
                    case 0: return Object.class;
                    case 1: return Object.class;
                    case 2: return Object.class;
                    case 3: return ImageIcon.class;
                    default: return Object.class;
                }
            }
        };
        tablaEmpleados.setModel(modeloTabla);
        modeloTabla.setColumnIdentifiers(nombreColumnas);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tablaEmpleados.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tablaEmpleados.getColumnModel().getColumn(1).setCellRenderer(tcr);
        tablaEmpleados.getColumnModel().getColumn(2).setCellRenderer(tcr);
        Object[] columna = new Object[4];
        for(int i = 0; i < arrayEmpleados.size(); i++){
            Empleado nuevoEmp = arrayEmpleados.get(i);
            /*nuevoEmp.getId();
            //Image image = null;
            URL url = new URL("https://jsonformatter.org/img/Maria-Sharapova.jpg");
            Image image = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(image);
            String[] datosFila = {nuevoEmp.getId(), "b", "c", icon};
            modeloTabla.addRow(datosFila);

             */
            columna[0] = nuevoEmp.getId();
            columna[1] = nuevoEmp.getFirstName();
            columna[2] = nuevoEmp.getLastName();
            //System.out.println(nuevoEmp.getPhoto());
            //URL url = new URL("https://raw.githubusercontent.com/EmaRCB/DesarrolloWeb/main/Recursos/CHAVEZ_EMANUEL.jpg");
            URL url = new URL(nuevoEmp.getPhoto());
            Image image = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(image);

            columna[3] = icon;
            modeloTabla.addRow(columna);
        }
    }
    /*public static void main(String[] args) throws IOException {
        VistaListado nuevaVentana = new VistaListado();
        nuevaVentana.setVisible(true);
    }*/
}

