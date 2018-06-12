import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
public class GridBagLayoutDemo implements ActionListener {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    JTable jt;
     String column[]={"Nombre","Artista","Duracion","Tamaño(MB)"};

    public void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
  String data[][] = {{"---","---","---","---"}};
 jt=new JTable(data,column);
 jt.setBounds(30,40,200,300);
 JScrollPane sp=new JScrollPane(jt);
 //////////////
        JButton button;
    pane.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    if (shouldFill) {
    //natural height, maximum width
    c.fill = GridBagConstraints.HORIZONTAL;
    }

    button = new JButton("Long-Named Button 4");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 200;      //make this component tall
    c.weightx = 0.5;
    c.gridwidth = 200;
    c.gridx = 0;
    c.gridy = 1;
    pane.add(sp, c);

    JTextField search = new JTextField();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 0;
    c.weighty = 1.0;
    c.anchor = GridBagConstraints.PAGE_END;
    c.gridx = 0;
    c.gridwidth = 1;
    c.gridy = 2;
    pane.add(search,c);

    button = new JButton("5");
    button.addActionListener(this);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 0;       //reset to default
    c.weighty = 1.0;   //request any extra vertical space
    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
    c.insets = new Insets(10,0,0,0);  //top padding
    c.gridx = 1;       //aligned with button 2
    c.gridwidth = 1;   //2 columns wide
    c.gridy = 2;       //third row
    pane.add(button, c);
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
      String data[][]={ {"101","Amit","670000"},
                            {"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},
                            {"101","Sachin","700000"}};
      DefaultTableModel model = new DefaultTableModel(data,column); // for example
      jt.setModel(model);
      model.fireTableDataChanged();

    }
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GridBagLayoutDemo d = new GridBagLayoutDemo();
                d.createAndShowGUI();
            }
        });
    }
}
