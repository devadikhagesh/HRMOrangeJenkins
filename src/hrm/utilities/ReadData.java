package hrm.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadData {
 public static String  getData(String filename, String key) throws Exception {
	String filelocation=".//resources//"+filename+".properties";
	FileInputStream inputStream=new FileInputStream(filelocation);
	Properties pro=new Properties();
	pro.load(inputStream);
	return pro.getProperty(key);
 }
}
