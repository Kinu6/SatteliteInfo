package satteliteInfo;

import org.testng.annotations.Test;

public class ReadDatafromCmdLine {
	@Test
	public void readRuntimeData() {
		String Bvalue= System.getProperty("browser");  //run time parameter
		System.out.println(Bvalue);
		String Uvalue= System.getProperty("url");
		System.out.println(Uvalue);
	}
}
