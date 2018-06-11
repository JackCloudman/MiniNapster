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
}
