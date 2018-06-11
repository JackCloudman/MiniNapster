public class Command{
  private ConexionBD db;
  public Command(){
    try{
      db = new ConexionBD();
    }catch(Exception e){
      System.out.println("Error al conectarse a la base de datos!");
      System.exit(1);
    }
  }
  public Message proccesCommand(Message m){
    try{
      String c = m.getCommand();
    if(c.equals("login")){
      return login(m);
    }else if (c.equals("register")) {
      return register(m);
    }
    else{
      return new Message("Comando no encontrado!",false);
    }
  }catch (Exception e) {
    System.out.println(e);
    return new Message("Respuesta equivocada!",false);
  }
  }
  private Message register(Message m)throws Exception{
    if(db.insert(m.getUser(),m.getPassword())){
      return new Message("Usuario creado! Ahora puedes iniciar sesion!",true);
    }else{
      return new Message("El usuario ya existe! Intente iniciar sesion",false);
    }
  }
  private Message login(Message m) throws Exception{
    if(db.login(m.getUser(),m.getPassword())){
      return new Message("Has iniciado sesion!",true);
    }else{
        return new Message("Error en usuario o contraseña!",false);
    }
  }
}
