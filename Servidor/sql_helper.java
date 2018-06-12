import java.util.*;
import java.text.*;
import java.sql.*;
import java.io.FileInputStream;
import java.io.File;
class sql_helper {
  Connection conexion = null;
  Config cfg;
  public sql_helper(){
    cfg = new Config();
    conexion = getConnection();
    }
  public Connection getConnection(){
    Connection conn;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String dbhost = cfg.get("dbhost");
      String dbport = cfg.get("dbport");
      String dbname = cfg.get("dbname");
      String dbUser = cfg.get("dbuser");
      String dbPwd = "";
      String url = "jdbc:mysql://"+dbhost+":"+dbport+"/"+dbname;
      System.out.println(url);
      conn = DriverManager.getConnection(url,dbUser,dbPwd);
    }catch (Exception e) {
      conn = null;
      System.out.println(e);
    }
    return conn;
  }
  public boolean existUser(String nickname) throws Exception{
    if(conexion==null){
      System.out.println("No se realizo correctamente la conexion! Verifica el estado de tu red!");
      return true;
    }
    String query = "Select * from sistema_usuarios where nickname='"+nickname+"'";
    Statement stmt = conexion.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    if(rs.next()){
      return true;
    }
    return false;
  }
  public boolean registrar(String nickname,String password){
    try{
      if(existUser(nickname)){
        return false;
      }
      String query= "Insert into sistema_usuarios(nickname,password) values(?,?)";
      if(conexion==null){
        System.out.println("No se realizo correctamente la conexion! Verifica el estado de tu red!");
        return false;
      }
      PreparedStatement stmt = null;
      stmt = conexion.prepareStatement(query);
      stmt.setString(1,nickname);
      stmt.setString(2,password);
      stmt.executeUpdate();
      return true;
    }catch(Exception e){
      System.out.println(e);
      return false;
    }
  }
  public boolean login(String nickname,String password) throws Exception{
    if(conexion==null){
      System.out.println("No se realizo correctamente la conexion! Verifica el estado de tu red!");
      return false;
    }
    String query = "Select * from sistema_usuarios where nickname='"+nickname+"' and password='"+password+"'";
    Statement stmt = conexion.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    if(rs.next()){
      return true;
    }
    return false;
  }
  public boolean upload(String titulo,String duracion,String artista,String album){
    try{
      String query= "Insert into canciones(nombre,duracion,artista,album,usuario) values(?,?,?,?,?)";
      if(conexion==null){
        System.out.println("No se realizo correctamente la conexion! Verifica el estado de tu red!");
        return false;
      }
      PreparedStatement stmt = null;
      stmt = conexion.prepareStatement(query);
      stmt.setString(1,titulo);
      stmt.setString(2,duracion);
      stmt.setString(3,artista);
      stmt.setString(4,album);
      stmt.setInt(5,1);//id de usuario
      stmt.executeUpdate();
      return true;
    }catch(Exception e){
      System.out.println(e);
      return false;
    }
  }
  public boolean deletesongs(int user_id)throws Exception{
      if(conexion==null){
        System.out.println("No se realizo correctamente la conexion! Verifica el estado de tu red!");
        return false;
      }
      String query = "DELETE FROM canciones WHERE usuario= '"+user_id+"'";
      Statement stmt = conexion.createStatement();
      stmt.executeUpdate(query);
      return true;
  }
  public ArrayList<String[]> search(String name)throws Exception{
    String query = "Select DISTINCT(c.id_cancion),c.nombre titulo,c.duracion duracion,c.artista artista,c.album album,u.ip from canciones c join usuario_ip u on c.usuario=u.usuario where c.nombre REGEXP '"+name+"' or c.album REGEXP '"+name+"' or c.artista REGEXP '"+name+"'";
    Statement stmt = conexion.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    ArrayList<String[]> lista = new ArrayList<String[]>();
    String[] song;
    while (rs.next()) {
      song = new String[] {rs.getString("titulo"),rs.getString("duracion"),rs.getString("artista"),rs.getString("album"),rs.getString("duracion"),rs.getString("ip")};
      lista.add(song);
    }
    return lista;
  }
}
