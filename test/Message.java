import java.io.Serializable;
import java.io.*;
import java.io.RandomAccessFile;
public class Message implements Serializable{
  private String command,file_name,response;
  private File file;
  private byte[] fileByte;
  public Message(String command,String user,String password){
    this.command = command;
  }
  public Message(String command,String file_name){
    this.command = command;
    this.file_name = file_name;
  }
  public Message(String response,File file){
    try{
    this.response= response;
    this.file = file;
    //fileByte = File.readAllBytes(file.toPath());
    RandomAccessFile f = new RandomAccessFile(file.getName(),"r");
    fileByte = new byte[(int)f.length()];
    f.readFully(fileByte);
  }catch(Exception e){
    System.out.println(e);
  }
  }
  public String getCommand(){
    return command;
  }
  public String getFileName(){
    return file_name;
  }
  public String getResponse(){
    return response;
  }
  public File getFile(){
    return file;
  }
  public byte[] getFileByte(){
    return fileByte;
  }
}
