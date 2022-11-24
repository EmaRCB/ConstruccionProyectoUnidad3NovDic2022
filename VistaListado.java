import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class VistaListado extends JFrame {
    JFrame ventanaListaEmpleados;
    public VistaListado() throws IOException {
        iniciarVentana();
        ArrayList<Empleado> arrayEmpleados = new ArrayList<Empleado>();
        Empleado nuevoEmpleado = new Empleado ("123", "Emanuel", "Bagundo", "https://jsonformatter.org/img/tom-cruise.jpg");
        arrayEmpleados.add(nuevoEmpleado);
        mostrarDatos(arrayEmpleados);
    }
    public void iniciarVentana(){
        ventanaListaEmpleados = new JFrame();
        ventanaListaEmpleados.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventanaListaEmpleados.setVisible(true);
        ventanaListaEmpleados.setSize(1000, 536);
        ventanaListaEmpleados.setLocationRelativeTo(null);



    }
    //
    public void mostrarDatos(ArrayList<Empleado> arrayEmpleados) throws IOException {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1000, 500);
        panel.setBackground(new Color(216, 191, 216));
        panel.setLayout(null);
        ventanaListaEmpleados.getContentPane().add(panel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 20, 960, 460);
        panel.add(scrollPane);
        JTable tablaEmpleados = new JTable();
        tablaEmpleados.setBackground(new Color(224, 255, 255));
        scrollPane.getViewport().add(tablaEmpleados);
        tablaEmpleados.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 43));
        tablaEmpleados.setFont(new Font("Serif", Font.BOLD, 20));
        tablaEmpleados.setRowHeight(300);

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
            System.out.println(nuevoEmp.getPhoto());
           
            URL url = new URL(nuevoEmp.getPhoto());
            Image image = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(image);

            columna[3] = icon;
            modeloTabla.addRow(columna);
        }
    }
    public static void main(String[] args) throws IOException {
        VistaListado nuevaVentana = new VistaListado();
        nuevaVentana.setVisible(true);
    }
}

