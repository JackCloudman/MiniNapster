import java.io.Serializable;
public class Message implements Serializable{
  private String command;
  public Message(String command,String user,String password){
    this.command = command;
  }
  public void setCommand(String command){
    this.command = command;
  }
  public String getCommand(){
    return command;
  }
}
