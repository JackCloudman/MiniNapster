import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;
public class Login extends JFrame implements ActionListener{
  private JButton login;
  private JButton register;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JTextField usuario;
  private JPasswordField password;
  private Command execute;
  public Login(){
    execute = new Command();
    this.initComponents();
    setSize(430,300);
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
  private void initComponents() {

      usuario = new JTextField();
      password = new JPasswordField();
      login = new JButton();
      login.addActionListener(this);
      register = new JButton();
      register.addActionListener(this);
      jLabel1 = new JLabel();
      jLabel2 = new JLabel();

      login.setText("Iniciar");

      register.setText("Registrar");

      jLabel1.setText("Usuario");

      jLabel2.setText("Contraseña");

      GroupLayout layout = new GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addContainerGap(123, Short.MAX_VALUE)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addComponent(usuario, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                  .addComponent(password, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                  .addGroup(layout.createSequentialGroup()
                      .addComponent(login)
                      .addGap(31, 31, 31)
                      .addComponent(register)))
              .addGap(104, 104, 104))
          .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                      .addGap(174, 174, 174)
                      .addComponent(jLabel1))
                  .addGroup(layout.createSequentialGroup()
                      .addGap(175, 175, 175)
                      .addComponent(jLabel2)))
              .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addGap(54, 54, 54)
              .addComponent(jLabel1)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jLabel2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addGap(18, 18, 18)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                  .addComponent(login)
                  .addComponent(register))
              .addContainerGap(51, Short.MAX_VALUE))
      );
  }
  public void actionPerformed(ActionEvent e){
    JButton b = (JButton)e.getSource();
    String susuario = usuario.getText();
    String spassword = String.valueOf(password.getPassword());
    System.out.println("Usuario: "+susuario+" Password: "+spassword);
    if(susuario.equals("")|| spassword.equals("")){
      JOptionPane.showMessageDialog(null, "Ingresa un usuario y contraseña!");
      return;
    }
    if(b==register){
      if(execute.register(susuario,spassword)){
        //setVisible(false);
      }
      System.out.println("Registro!");
    }
    if(b==login){
      Message response= execute.login(susuario,spassword);
      if(response.getResult()){
        setVisible(false);
        Cliente c = new Cliente(response.getData());
        c.createAndShowGUI();
      }
      System.out.println("Iniciar sesion!");
    }
    return;
  }
  public static void main(String[] args) {
    try{
      new Login();
    }catch (Exception e) {
      System.out.println(e);
    }
  }
}
