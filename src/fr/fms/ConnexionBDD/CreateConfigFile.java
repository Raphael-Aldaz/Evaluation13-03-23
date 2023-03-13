package fr.fms.ConnexionBDD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class CreateConfigFile extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7097271860551248095L;

	public static void CreateConf() throws IOException  {
		
			Hashtable<String, String> config = new Hashtable<String, String>();
			config.put("driver.class", "org.mariadb.jdbc.Driver");
			config.put("url", "jdbc:mariadb://localhost:3306/Formation");
			config.put("login", "root");
			config.put("password", "fms2023");
			
			
			File configFile = new File("files/config.properties");
			BufferedWriter BW = null;
			FileWriter FW = null;
			try {
			if(!configFile.exists()) {
				configFile.createNewFile();
			}
			
			FW = new FileWriter(configFile);
			BW = new BufferedWriter(FW);
			
			for(Map.Entry<String, String> entry : config.entrySet()) {
				BW.write((entry.getKey() + ":" + entry.getValue()));
				BW.newLine();
			}
			
			BW.close();	

			} catch (IOException e) {
				e.printStackTrace();
			}
}

}
