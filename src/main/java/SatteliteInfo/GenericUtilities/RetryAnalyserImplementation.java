package SatteliteInfo.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This is an implementation class for IRetryAnalyser interface of TestNg
 * 
 * @author kravi
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {

	public boolean retry(ITestResult result) {
		int count = 0;
		int retryCount = 4;
		while (count < retryCount) {
			count++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
