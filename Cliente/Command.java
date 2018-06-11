import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;
public class Command{
  private Config cfg;
  private String host;
  private int port;
  public Command(){
    cfg = new Config();
    port = Integer.parseInt(cfg.get("port"));
    host = cfg.get("host");
  }
  private Message send(Message request) throws Exception{
    Socket cs = new Socket(host,port);
    ObjectOutputStream salida = new ObjectOutputStream(cs.getOutputStream());
    salida.writeObject(request);
    System.out.println("Objeto enviado!");
    ObjectInputStream entrada = new ObjectInputStream(cs.getInputStream());
    return (Message)entrada.readObject();
  }
  public boolean login(String user,String password){
    try{
      Message request = new Message("login",user,password);
      Message response = send(request);
      boolean r = response.getResult();
      String m = response.getResponse();
      JOptionPane.showMessageDialog(null,m);
      return r;
    }catch (Exception e) {
      JOptionPane.showMessageDialog(null,"No se pudo conectar al servidor!");
      System.out.println(e);
      return false;
    }
  }
  public boolean register(String user,String password){
    try{
    Message request = new Message("register",user,password);
    Message response = send(request);
    boolean r = response.getResult();
    String m = response.getResponse();
    JOptionPane.showMessageDialog(null,m);
    return r;
  }catch (Exception e) {
    JOptionPane.showMessageDialog(null,"No se pudo conectar al servidor!");
    return false;
  }
  }

}
