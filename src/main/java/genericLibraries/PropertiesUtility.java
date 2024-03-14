package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This Class Contains reusable methods to read data from properties file
 * @author vojja mahender
 *
 */

public class PropertiesUtility {
	private  Properties property;
	/**
	 * This method initializes properties file
	 * @param filepath
	 */
		
	public  void propertiesInit(String filepath) {
		FileInputStream fis=null;
		 try {
			fis= new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 property= new Properties();
		 
		 try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method fetches data from properties file based on key passed
	 * @param key
	 * @return
	 */
	public String readProperty(String key) {
		return property.getProperty(key);
	}
}
