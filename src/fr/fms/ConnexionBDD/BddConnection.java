package fr.fms.ConnexionBDD;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 
 * @author AldazR
 * Connexion to my BDD with the Singleton Pattern
 *
 */
public class BddConnection {
	private static Connection connection;
	
	public  BddConnection() {
	Properties props = null;
	
	try {
		CreateConfigFile.CreateConf();;
		 props = readConfigFile("files/config.properties");
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	try {
		Class.forName(props.getProperty("driver.class"));
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	
	String url = props.getProperty("url");
	String login =props.getProperty("login");
	String password =props.getProperty("password");
	try {
		connection = DriverManager.getConnection(url, login, password);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
public static synchronized Connection getConnection() {
	
		if(connection == null) {
			new BddConnection();
		}
		return connection;
	}
/**
 * 
 * @param file
 * @return
 * @throws IOException
 * Method for read the config file
 */
public static Properties readConfigFile(String file) throws IOException  {
	 FileInputStream fis = null;
	 Properties props = null;
	 try {
		 fis = new FileInputStream(file);
		 props = new Properties();
		 props.load(fis);
	 } catch (Exception e) {
		e.printStackTrace();
	} finally {
		fis.close();
	}
	 return props;
}
}
