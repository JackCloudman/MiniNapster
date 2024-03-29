import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;
public class Message implements Serializable{
  private String command;
  private String user;
  private String password;
  private String response;
  private boolean result;
  private String data;
  private ArrayList<Cancion> listacanciones;
  private byte[] filebytes;
  //Constructores para cliente
  public Message(String command,String user,String password){
    this.command = command;
    this.user = user;
    this.password = password;
  }
  public Message(String command,String user,ArrayList<Cancion> listacanciones){
    this.command = command;
    this.user = user;
    this.listacanciones = listacanciones;
  }
  public Message(String command,String data){
    this.command = command;
    this.data = data;
  }
  //Constructores para servidor
  public Message(String response,boolean result){
    command = "response";
    this.response = response;
    this.result = result;
  }
  public Message(String response,ArrayList<Cancion> listacanciones){
    command = "response";
    this.response = response;
    this.listacanciones = listacanciones;
    if(listacanciones.size()==0){
      this.result = false;
    }else{
      this.result = true;
    }
  }
  //Constructores para el MiniServer
  public Message(String response,byte[] filebytes){
    this.filebytes = filebytes;
    this.response = response;
  }
  //
  public void setCommand(String command){
    this.command = command;
  }
  public String getCommand(){
    return command;
  }
  public String getUser(){
    return user;
  }
  public String getPassword(){
    return password;
  }
  public String getResponse(){
    return response;
  }
  public boolean getResult(){
    return result;
  }
  public ArrayList<Cancion> getSongs(){
    return listacanciones;
  }
  public String getdata(){
    return data;
  }
  public String getData(){
    return data;
  }
  ///
  public void setUser(String user){
    this.user = user;
  }
  public void setData(String data){
    this.data = data;
  }
  public void setResult(boolean result){
    this.result = result;
  }
  public byte[] getFileBytes(){
    return filebytes;
  }
}
