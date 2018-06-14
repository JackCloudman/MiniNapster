import java.net.*;
import java.io.*;
public class MiniServer implements Runnable{
  String path;
  Thread tMiniServer;
  ServerSocket ss;
  Socket cs;
  Command execute;
  public MiniServer(String path){
    System.out.println("Creando MiniServer en: "+path);
    this.path = path;
    execute = new Command();
    tMiniServer = new Thread(this);
    tMiniServer.start();
  }
  public void updatePath(String path){
    this.path = path;
  }
  public void run(){
    try{
      ss = new ServerSocket(9000);
      ObjectOutputStream salidaCliente;
      ObjectInputStream entrada;
      Message m,response;
      while(true){
        cs = ss.accept();
        System.out.println("Nueva peticion");
        salidaCliente = new ObjectOutputStream(cs.getOutputStream());
        entrada = new ObjectInputStream(cs.getInputStream());
        m = (Message)entrada.readObject();
        response = execute.createFile(path,m.getData());
        salidaCliente.writeObject(response);
        cs.close();
        System.out.println("Conexion terminada!");
    }
    }catch(Exception e){
      System.out.println(e);
    }
  }

}
