import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaListado extends JFrame {
    JFrame ventanaListaEmpleados;
    public VistaListado() {
        iniciarVentana();
    }
    public void iniciarVentana(){
        ventanaListaEmpleados = new JFrame();
        ventanaListaEmpleados.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventanaListaEmpleados.setVisible(true);
        ventanaListaEmpleados.setSize(800, 436);
        ventanaListaEmpleados.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 800, 400);
        panel.setBackground(new Color(216, 191, 216));
        panel.setLayout(null);
        ventanaListaEmpleados.getContentPane().add(panel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 20, 760, 360);
        panel.add(scrollPane);
        JTable tablaEmpleados = new JTable();
        tablaEmpleados.setBackground(new Color(224, 255, 255));
        scrollPane.getViewport().add(tablaEmpleados);
        tablaEmpleados.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));
        tablaEmpleados.setFont(new Font("Serif", Font.BOLD, 20));

        //Vista temporal de las columnas de la lista
        String[] nombreColumnas = {"ID","First Name", "Last Name", "Photo"};
        DefaultTableModel modeloTabla = (DefaultTableModel)tablaEmpleados.getModel();
        modeloTabla.setColumnIdentifiers(nombreColumnas);

    }
    public static void main(String[] args) {
        VistaListado nuevaVentana = new VistaListado();
        nuevaVentana.setVisible(true);
    }
}
