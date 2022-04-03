import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Esta clase define el visor grafico con tecnologia Swing de Java
 */
public class Swing{

    /**
     * Metodo principal que ejecuta la aplicacion
     */
    public static void main(String[] args) {

        Swing ventana = new Swing();
        ventana.Swing();

    }

    JFrame Ventana = new JFrame();
    JTabbedPane pestanias;
    JPanel panel1, panel2, panel3;
    JLabel DNI, Nombre, Direccion, Telefono, FechaNac, GrupSan, RH, DNID, NombreDonante, TipoSangre, GrupSan1, RH1;
    JTextField dni1, Nombre1, Direccion1, Telefono1, DNID1;
    JComboBox Sangre, Rh1, Sangre1, Rh2;
    JDateChooser dateChooser;
    JTable table, table1, table2;
    JScrollPane scrollPane, scrollPane1, scrollPane2;
    JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7;


    /**
     * Metodo donde se encapsula el visor grafico Swing
     */
    public void Swing(){


        //Parametros asociados a la ventana
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ventana.setBounds(100, 100, 550, 750);
        Ventana.setVisible(true);
        Ventana.setTitle("Banco de Sangre");

        //Creamos el conjunto de pestañas
        pestanias = new JTabbedPane();

        //Creamos el panel y lo añadimos a las pestañas
        panel1 = new JPanel();
        pestanias.addTab("Donantes", panel1);

        //Panel 2
        panel2=new JPanel();
        pestanias.addTab("Donaciones", panel2);

        //Panel 3
        panel3=new JPanel();
        pestanias.addTab("Compatibilidad", panel3);

        Ventana.getContentPane().add(pestanias);

        /**
         * Definimos las diferentes pestanias del visor para mayor comodidad del ususario
         */

        //DONANTES
        DNI = new JLabel("DNI");
        Nombre = new JLabel("Nombre");
        Direccion = new JLabel("Dirección");
        Telefono = new JLabel("Teléfono");


        dni1 = new JTextField(9);
        dni1.setBounds(10,10,100,30);

        Nombre1 = new JTextField(16);
        Nombre1.setBounds(10,50,100,30);

        Direccion1 = new JTextField(16);
        Direccion1.setBounds(10,90,100,30);

        Telefono1 = new JTextField(9);
        Telefono1.setBounds(10,130,100,30);

        FechaNac = new JLabel("Fecha de nacimiento");
        dateChooser = new JDateChooser();
        dateChooser.setBounds(10,10,250,20);
        dateChooser.getJCalendar();
        dateChooser = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
        dateChooser = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        dateChooser.getDate();

        GrupSan = new JLabel("Grupo Sanguíneo");
        Sangre = new JComboBox<String>();
        Sangre.setBounds(10,10,150,20);
        Sangre.addItem("A");
        Sangre.addItem("B");
        Sangre.addItem("0");
        Sangre.addItem("AB");

        RH = new JLabel("Factor RH");
        Rh1 = new JComboBox<String>();
        Rh1.setBounds(10,10,150,20);
        Rh1.addItem("+");
        Rh1.addItem("-");

        panel1.add(DNI);
        panel1.add(dni1);
        panel1.add(Nombre);
        panel1.add(Nombre1);
        panel1.add(Direccion);
        panel1.add(Direccion1);
        panel1.add(Telefono);
        panel1.add(Telefono1);
        panel1.add(FechaNac);
        panel1.add(dateChooser);
        panel1.add(GrupSan);
        panel1.add(Sangre);
        panel1.add(RH);
        panel1.add(Rh1);

        /**
         * Diferentes objetos para recoger la información a aniadir/consultar/eliminar en la pestania donantes
         */

        //Tabla
        table = CreateTableDonantes();
        scrollPane = new JScrollPane(table);
        panel1.add(scrollPane);
        /*panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));*/

        //Botones
        boton1 = new JButton("Consultar DNI");
        boton1.addActionListener(this::actionPerformed);
        panel1.add(boton1);
        boton2 = new JButton("Consultar todos");
        panel1.add(boton2);
        boton3 = new JButton("Insertar");
        panel1.add(boton3);
        boton4 = new JButton("Modificar");
        panel1.add(boton4);
        boton5 = new JButton("Eliminar");
        panel1.add(boton5);


        // PESTAÑA DONACIONES
        DNID = new JLabel("DNI Donante");
        panel2.add(DNID);

        DNID1 = new JTextField(9);
        panel2.add(DNID1);

        boton6 = new JButton("Consultar Donaciones");
        panel2.add(boton6);

        NombreDonante = new JLabel();
        panel2.add(NombreDonante);

        TipoSangre = new JLabel();
        panel2.add(TipoSangre);

        table1 = CreateTableDonaciones();
        scrollPane1 = new JScrollPane(table1);
        panel2.add(scrollPane1);

        /**
         * Diferentes objetos para recoger la informacion a consultar en la pestania donaciones
         */


        // PESTAÑA COMPATIBILIDAD
        GrupSan1 = new JLabel("Grupo Sanguíneo");
        Sangre1 = new JComboBox<String>();
        Sangre1.addItem("A");
        Sangre1.addItem("B");
        Sangre1.addItem("0");
        Sangre1.addItem("AB");
        panel3.add(GrupSan1);
        panel3.add(Sangre1);

        RH1 = new JLabel("Factor RH");
        Rh2 = new JComboBox<String>();
        Rh2.addItem("+");
        Rh2.addItem("-");
        panel3.add(RH1);
        panel3.add(Rh2);

        boton7 = new JButton("Averiguar compatibilidad");
        panel3.add(boton7);

        table2 = CreateTableCompatibilidad();
        scrollPane2 = new JScrollPane(table2);
        panel3.add(scrollPane2);
        /**
         * Diferentes objetos para recoger la informacion a consultar en la pestania compatibilidad
         */
    }

    /**
     * Este metodo crea una tabla donde se mostrara la informacion solicitada al usuario
     * @return table Este parametro define la tabla en cuestion donde se mostrara la informacion ordenada
     */
    public JTable CreateTableDonantes() {
        String[] columnNames = {"DNI", "Nombre", "Dirección", "Teléfono", "Fecha de nacimiento", "Grupo Sanguíneo", "Factor RH"};
        Object[][] data = {};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        table.setSize(400, 300);
        TableColumnModel columnModel = table.getColumnModel();
        return table;
    }


    /**
     * Este metodo crea una tabla donde se mostrara la informacion solicitada al usuario
     * @return table Este parametro define la tabla en cuestion donde se mostrara la informacion ordenada
     */
    public JTable CreateTableDonaciones() {
        String[] columnNames = {"Cod. Sanit.", "Nombre Sanitario", "Fecha", "Cantidad"};
        Object[][] data = {};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        TableColumnModel columnModel = table.getColumnModel();
        return table;
    }


    /**
     * Este metodo crea una tabla donde se mostrará la informacion solicitada al usuario
     * @return table
     */
    public JTable CreateTableCompatibilidad() {
        String[] columnNames = {"Puedes donar a", "Puedes recibir de"};
        Object[][] data = {};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        TableColumnModel columnModel = table.getColumnModel();
        return table;
    }


    public void actionPerformed(ActionEvent e){
        if (e.getSource() == boton1) {

        } else if(e.getSource() == boton2){

        } else if(e.getSource() == boton3){

        } else if(e.getSource() == boton4){

        } else if(e.getSource() == boton5){

        } else if(e.getSource() == boton6){

        } else if(e.getSource() == boton7){

        }
    }
}