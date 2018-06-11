import java.io.*;
import java.net.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor{
    Config cfg;
    String host;
    int port;
    Thread t;
    ServerSocket ss;
    Socket cs;
    ObjectOutputStream salidaCliente;
    public Servidor(){
        cfg = new Config();
        port = Integer.parseInt(cfg.get("port"));
        System.out.println(port);
        //Thread hilo= new Thread(this);
        this.start();
    }
    public void start(){
      try{
        System.out.println("Servidor creado :o!");
        ss = new ServerSocket(port);
        System.out.println(port);
        //cs = new Socket();
        while (true) {
            cs = ss.accept();
            System.out.println("Conexion establecida! ");
            salidaCliente = new ObjectOutputStream(cs.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(cs.getInputStream());
            Message m = (Message)entrada.readObject();
            System.out.println(m.getCommand());
            Thread.sleep(5000);
            Message response = new Message("Recibido! :D ","owo","awa");
            salidaCliente.writeObject(response);
            cs.close();
            System.out.println("Conexion terminada!");
        }
      }catch(Exception e){
        System.out.println(e);
      }
    }
    public static void main(String[] args) {
      new Servidor();
    }

}
