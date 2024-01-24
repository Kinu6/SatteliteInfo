package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		// Open the file in Java readable format
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");

		// Create object for Properties class
		Properties pObj = new Properties();

		// Load the file
		pObj.load(fisp);

		// Access the values
		System.out.println(pObj.getProperty("url"));

	}

}
