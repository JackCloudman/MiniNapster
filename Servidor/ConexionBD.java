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
    public int login(String nickname,String password,String ip)throws Exception{
        return sql.login(nickname,password,ip);
    }
    public boolean upload(ArrayList<Cancion> listacanciones,String user){
      boolean response = true;
      try{
        if(!(sql.deletesongs(1))){
          System.out.println("Error al eliminar las canciones XD");
          return false;
        }
      }catch (Exception e) {
        return false;
      }
      for(Cancion cancion:listacanciones){
        if(!(sql.upload(cancion,user))){
          response = false;
        }
      }
      return response;
    }
    public ArrayList<Cancion> search(String name)throws Exception{
      return sql.search(name);
    }
}
