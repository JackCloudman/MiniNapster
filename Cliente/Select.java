import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class Select{
  public static String selectFolder(){
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("Selecciona una carpeta");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //
    // disable the "All files" option.
    //
    chooser.setAcceptAllFileFilterUsed(false);
    //
    JFrame f = new JFrame();
    if (chooser.showOpenDialog(f) == JFileChooser.APPROVE_OPTION) {
         return chooser.getSelectedFile().toPath().toString();
      }
    else {
      return "";
      }
  }
}
