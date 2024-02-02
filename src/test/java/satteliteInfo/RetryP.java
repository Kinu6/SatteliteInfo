package satteliteInfo;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryP{

	@Test (retryAnalyzer = SatteliteInfo.GenericUtilities.RetryAnalyserImplementation.class)
	public void RetryTestP(){
		int a=20;
		System.out.println(a);
		Assert.fail();

	}

}
