import java.io.Serializable;
public class Message implements Serializable{
  private String command;
  private String user;
  private String password;
  private String response;
  private boolean result;
  public Message(String command,String user,String password){
    this.command = command;
    this.user = user;
    this.password = password;
  }
  public Message(String response,boolean result){
    command = "response";
    this.response = response;
    this.result = result;
  }
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
}
