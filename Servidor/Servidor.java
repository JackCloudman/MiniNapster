import java.util.*;
public class Servidor{
    sql_helper sql; //Objeto que nos ayudara a conectarnos a la base de datos

    //Constructor 
    public Servidor()throws Exception{ 
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
    public void insert(String nickname,String password){
        sql.registrar(nickname,password);
        return;
    }
    public void login(String nickname,String password)throws Exception{
        sql.login(nickname,password);
        return;
    }
    public static void main(String[] args) {
        try{
            Servidor s = new Servidor();
            s.insert("cloudman","jack");
            s.login("jack","cloudman");
            System.out.println("Programa terminado!");
        }catch(Exception e){
            System.out.println(e);
        }

    }


}
