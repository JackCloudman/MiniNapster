import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.Arrays;
public class Cliente implements ActionListener {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    JButton buscar,carpeta;
    JTable jt;
    JTextField textobusqueda;
    String column[]={"Titulo","Duracion","Artista","Album"};
    String path;
    ArrayList<Cancion> lista;
    private Command execute;
    public Cliente(){
        execute = new Command();
    }
    // Componentes para el interfaz
    public void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        //Creando el jpanel
        String data[][] = {{"---","---","---","---"}};
        jt=new JTable(data,column);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //Datos para la interfaz
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 200;      //make this component tall
        c.weightx = 0.5;
        c.gridwidth = 200;
        c.gridx = 0;
        c.gridy = 1;
        //añadimos el jpanel a la interfaz
        pane.add(sp, c);
        //Creamos el TextView para la busqueda
        textobusqueda = new JTextField();
        //Datos para la interfaz
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.weighty = 0.5;
        c.insets = new Insets(10,0,0,0);  //top padding
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 2;
        //Añadimos el TextField a la interfaz
        pane.add(textobusqueda,c);

        buscar = new JButton("Buscar");
        buscar.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 1;   //2 columns wide
        c.gridy = 2;       //third row
        pane.add(buscar, c);

        carpeta = new JButton("Abrir Carpeta");
        carpeta.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 2;       //aligned with button 2
        c.gridwidth = 1;   //2 columns wide
        c.gridy = 2;       //third row
        pane.add(carpeta, c);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
      JButton btn = (JButton)e.getSource();
      if(btn==buscar){
      /*  lista = execute.search(textobusqueda.getText());
        if(lista==null){
          return;
        }
        String[][] data = lista.toArray(new String[][] {});
        DefaultTableModel model = new DefaultTableModel(data,column); // for example
        jt.setModel(model);
        model.fireTableDataChanged();*/
      /*String data[][]={ {"101","Amit","670000"},
                            {"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},
                            {"101","Sachin","700000"}};
      DefaultTableModel model = new DefaultTableModel(data,column); // for example
      jt.setModel(model);
      model.fireTableDataChanged();*/
      }
      if(btn==carpeta){
        path = Select.selectFolder();
        if(!path.equals("")){
            lista = Archivos.getSongs(path);
            execute.upload("jack",lista);
            for(Cancion cancion:lista){
              System.out.println(cancion.toString());
            }
          }

      }

    }
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Cliente d= new Cliente();
                d.createAndShowGUI();
            }
        });
    }
}
