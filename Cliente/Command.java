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
      Displayresponse(response);
      return response.getResult();
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
    Displayresponse(response);
    return response.getResult();
  }catch (Exception e) {
    JOptionPane.showMessageDialog(null,"No se pudo conectar al servidor!");
    return false;
  }
  }
  public void Displayresponse(Message response){
    boolean r = response.getResult();
    String m = response.getResponse();
    JOptionPane.showMessageDialog(null,m);
  }
  public boolean upload(String user,ArrayList<String[]> listacanciones){
    try{
      if(listacanciones.size()==0){
        JOptionPane.showMessageDialog(null,"La carpeta no tiene canciones!");
        return false;
      }
      Message request = new Message("upload",user,listacanciones);
      System.out.println("Subiendo...");
      Message response = send(request);
      Displayresponse(response);
      return response.getResult();
    }catch (Exception e) {
        JOptionPane.showMessageDialog(null,"No se pudo conectar al servidor!");
        return false;
      }
  }
  public ArrayList<String[]> search(String busqueda){
    try{
      if(busqueda.equals("")){
        JOptionPane.showMessageDialog(null,"Ingresa una palabra para buscar una cancion!");
        return null;
      }
      Message request = new Message("search",busqueda);
      System.out.println("Buscando...");
      Message response = send(request);
      Displayresponse(response);
      return response.getSongs();
    }catch (Exception e) {
        JOptionPane.showMessageDialog(null,"No se pudo conectar al servidor!");
        return null;
      }
  }

}
