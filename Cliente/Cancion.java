import java.io.Serializable;
public class Cancion implements Serializable{
  String titulo,album,duracion,artista,path;
  public Cancion(String titulo,String album,String duracion,String artista,String path){
    this.titulo = titulo;
    this.album = album;
    this.duracion = duracion;
    this.artista = artista;
    this.path = path;
  }
  public String getTitulo(){
    return titulo;
  }
  public String getAlbum(){
    return album;
  }
  public String getDuracion(){
    return duracion;
  }
  public String getArtista(){
    return artista;
  }
  public String getPath(){
    return path;
  }
  public String toString(){
    return "{titulo: "+titulo+",album: "+album+",duracion: "+duracion+",artista:"+artista+",path:"+path+"}";
  }
  public String[] toArray(){
    return new String []{titulo,album,duracion,artista,path};
  }

}
