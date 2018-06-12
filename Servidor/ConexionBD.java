import java.util.*;
public class ConexionBD{
    sql_helper sql; //Objeto que nos ayudara a conectarnos a la base de datos

    //Constructor
    public ConexionBD()throws Exception{
        int intentos=0;
        while(true){
            sql = new sql_helper();
            if(sql.conexion==null){
                System.out.println("No se pudo realizar la conexion a la base de datos!");
                System.out.println("Reintentando conexion...");
                Thread.sleep(5000);
            }
            else{
                System.out.println("Conexion establecida!");
                break;
            }
        }
    }
    public boolean insert(String nickname,String password){
        return sql.registrar(nickname,password);
    }
    public boolean login(String nickname,String password)throws Exception{
        return sql.login(nickname,password);
    }
    public boolean upload(ArrayList<String[]> listacanciones,String user){
      boolean response = true;
      try{
        if(!(sql.deletesongs(1))){
          System.out.println("Error al eliminar las canciones XD");
          return false;
        }
      }catch (Exception e) {
        return false;
      }
      for(String[] cancion:listacanciones){
        if(!(sql.upload(cancion[0],cancion[1],cancion[2],cancion[3]))){
          response = false;
        }
      }
      return response;
    }
    public ArrayList<String[]> search(String name)throws Exception{
      return sql.search(name);
    }
}
