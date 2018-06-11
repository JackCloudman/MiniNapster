import java.util.*;
import java.io.*;
import java.net.*;
public class MiniCliente{
	String host = "localhost";
	int puerto = 9000;
	ObjectOutputStream salidaServidor;
	Socket cs;
	public MiniCliente(){
		try{
		    cs = new Socket(host,puerto);
		    salidaServidor = new ObjectOutputStream(cs.getOutputStream());

        Message m = new Message("Hola mundo!");
        salidaServidor.writeObject(m);
        System.out.println("Objeto enviado!");
		    ObjectInputStream entrada = new ObjectInputStream(cs.getInputStream());
		    Message response = (Message)entrada.readObject();
        System.out.println(response.getCommand());
	  }catch(Exception e){
		    System.out.println(e);
	  }
	}
	public static void main(String s[]){
		new MiniCliente();
	}
}
