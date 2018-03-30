package com.wbl.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
	
	public static Properties loadproperties(String filename)
	{
		
		Properties prop=new Properties();
		
		try {
			prop.load(new FileInputStream(Constants.path+filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	

}