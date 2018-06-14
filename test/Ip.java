import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.*;
import java.util.*;
public class Ip{
    public static void main(String s[]){
try{
  final StringBuilder address = new StringBuilder(15);
  final TreeMap<Integer, NetworkInterface> sortedInterfaces = new TreeMap<Integer, NetworkInterface>();
  for (java.net.NetworkInterface networkInterface : Collections.list(java.net.NetworkInterface.getNetworkInterfaces())) {
  sortedInterfaces.put(networkInterface.getIndex(), networkInterface); }
  for (final java.net.NetworkInterface networkInterface : sortedInterfaces.values()) {
  if (networkInterface.isLoopback()) continue;
  for (final java.net.InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
  final java.net.InetAddress inetAddress = interfaceAddress.getAddress();
  if (inetAddress instanceof java.net.Inet4Address) { final java.net.Inet4Address inet4Address = (java.net.Inet4Address) inetAddress;
  final byte[] ipAddress = inet4Address.getAddress().clone();
  if (ipAddress.length != 4) continue;
  for (final byte ipAddressElement : ipAddress) {
  if (address.length() > 0) address.append('.');
  address.append(String.format("%03d", ipAddressElement & 0xff));
  } break; }
  }
  if (address.length() != 0) break;
  } if (address.length() != 15)
  address.delete(0, address.length());
  System.out.println(address);
    }catch(Exception e){}}
}
