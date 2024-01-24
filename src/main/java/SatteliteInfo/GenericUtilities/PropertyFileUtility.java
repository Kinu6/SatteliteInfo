package SatteliteInfo.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This Class consists of Generic Methods related to Property File
 * 
 * @author kravi
 *
 */

public class PropertyFileUtility {

	/**
	 * This Method will read data from Property File
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {

		FileInputStream fisp = new FileInputStream(IConstantsUtility.propertyFilePath);
		Properties pObj = new Properties();
		pObj.load(fisp);
		String value = pObj.getProperty(key);
		return value;

	}

}
