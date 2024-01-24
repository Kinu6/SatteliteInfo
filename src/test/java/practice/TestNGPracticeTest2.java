package practice;

import org.testng.annotations.Test;

public class TestNGPracticeTest2 {

	@Test(invocationCount = 2)
    public void createUser() {
		//Assert.fail();
	    System.out.println("CREATE");
    }
	@Test(enabled = true)
	public void modifyUser() {
		System.out.println("MODIFY");
	}
	@Test(dependsOnMethods = "createUser")
	public void deleteUser() {
		System.out.println("DELETE");
	}
}
