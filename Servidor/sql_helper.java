import java.util.*;
import java.text.*;
import java.sql.*;
import java.io.FileInputStream;
import java.io.File;
class sql_helper {
  String conexionUrl = "jdbc:mysql://localhost:3306/POO";
  String dbUser = "root";
  String dbPwd = "";
  Connection conexion = null;
  public sql_helper(){
    conexion = getConnection();
    }
  public Connection getConnection(){
    Connection conn;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/MiniNapster";
      conn = DriverManager.getConnection(url,dbUser,dbPwd);
    }catch (Exception e) {
      conn = null;
      System.out.println(e);
    }
    return conn;
  }
  public void registrar(String nickname,String password){
    try{
      String query= "Insert into sistema_usuarios(nickname,password) values(?,?)";
      if(conexion==null){
        System.out.println("No se realizo correctamente la conexion! Verifica el estado de tu red!");
        return;
      }
      PreparedStatement stmt = null;
      stmt = conexion.prepareStatement(query);
      stmt.setString(1,nickname);
      stmt.setString(2,password);
      stmt.executeUpdate();
    }catch(Exception e){
      System.out.println(e);
    }
  }
  public void login(String nickname,String password) throws Exception{
    if(conexion==null){
      System.out.println("No se realizo correctamente la conexion! Verifica el estado de tu red!");
      return;
    }

    Statement stmt = conexion.createStatement();
    ResultSet rs = stmt.executeQuery("Select * from sistema_usuarios");
    while(rs.next()){
      System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
    }
  }
}
