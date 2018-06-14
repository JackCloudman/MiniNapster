import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.*;
public class Ip{
    public static void main(String s[]){
try{
    InetAddress iAddress = InetAddress.getLocalHost();
  String currentIp = iAddress.getHostAddress();
  System.out.println("Current IP address : " +currentIp);
  Socket socket = new Socket();
socket.connect(new InetSocketAddress("google.com", 80));
System.out.println(socket.getLocalAddress()); 
    }catch(Exception e){}}
}
