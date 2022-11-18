package com.android.genericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	/**
	 * It is used to read the date form commonData.properties File base on which you pass as an argument
	 * @author A1Q5SAYJ(PRAKASH)
	 * @param key
	 * @throws Throwable 
	 */

	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis= new FileInputStream(IpathConstants.FilePath);
		Properties pObj= new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		System.out.println(value);
		return value;		
	}

}
