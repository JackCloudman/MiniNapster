import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.lang.Float;
public class AudioParser {

    public String[] getData(File file) {
        try {
          String fileLocation = file.toPath().toString();
        InputStream input = new FileInputStream(new File(fileLocation));
        ContentHandler handler = new DefaultHandler();
        Metadata metadata = new Metadata();
        Parser parser = new Mp3Parser();
        ParseContext parseCtx = new ParseContext();
        parser.parse(input, handler, metadata, parseCtx);
        input.close();
        String[] metadataNames = metadata.names();
        // Retrieve the necessary info from metadata
        // Names - title, xmpDM:artist etc. - mentioned below may differ based
        String titulo = metadata.get("title");
        String duracion = metadata.get("xmpDM:duration");
        int intduracion = (int)(Float.parseFloat(duracion)/1000);
        int minutos = intduracion/60;
        int segundos = intduracion%60;
        duracion = minutos+"m "+segundos+"s";
        String artista = metadata.get("xmpDM:artist");
        String album = metadata.get("xmpDM:album");
        if(titulo==null){
          titulo = file.getName();
        }
        if(duracion==null){
          duracion = "0";
        }
        if(artista==null){
          artista = "Artista Desconocido";
        }
        if(album==null){
          album = "Album Desconocido";
        }
        return new String[] {titulo,duracion,artista,album};

        } catch (FileNotFoundException e) {
        return null;
        } catch (IOException e) {
        return null;
        } catch (SAXException e) {
        return null;
        } catch (TikaException e) {
        return null;
        }
        }
    }
