import java.util.*;
import java.util.Properties;
 
public class Config
{
   Properties configFile;
   public Config()
   {
	configFile = new java.util.Properties();
	try {
	  configFile.load(this.getClass().getClassLoader().
	  getResourceAsStream("config.cfg"));
	}catch(Exception eta){
	    eta.printStackTrace();
	}
   }
 
   public String get(String key)
   {
	String value = this.configFile.getProperty(key);
	return value;
   }
}

