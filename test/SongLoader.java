import java.io.*;

public class SongLoader {
	public static void main(String s[]){
		System.out.println("Generando mp3...");
		importarCancion("/home/jack/MiniNapster/test/","/home/jack/MiniNapster/test/musica/", "cancion.mp3");
		
	}
	public static void importarCancion(String dirFrom, String dirTo, String song){
		try {
			File archivoFrom = new File(dirFrom+song);
			InputStream inputStream = new FileInputStream(archivoFrom);
			File archivo = new File(dirTo+song);
			FileOutputStream outputStream
					= new FileOutputStream(archivo);
				int bits = inputStream.read();
				while (bits != (-1)) {
					outputStream.write(bits);
					bits = inputStream.read();
				}
				inputStream.close();
				outputStream.close();
			}catch(Exception e){
				
			}
	}
}
