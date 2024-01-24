package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class AssertionPracticeb {
  public void assertionPractice() {
	  boolean base=true;
	  if(base=true) {
		  Assert.fail();
		  System.out.println("PASS");
	  }
	  else {
		  System.out.println("FAIL");
	  }
  }
}
