import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
public class Archivos{

public static ArrayList<Cancion> getSongs(String path) {
    File folder = new File(path);
    ArrayList<Cancion> lista = new ArrayList<Cancion>();
    Cancion song;
    AudioParser a = new AudioParser();
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
        } else {
            if(getFileExtension(fileEntry).equals("mp3")){
                song = a.getData(fileEntry);
                if(!(song==null)){
                  lista.add(song);
                }

            }
        }
    }
    return lista;
}
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
