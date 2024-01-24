package practice;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(invocationCount = 2)
	public void createUser() {
		System.out.println("CREATE USER");
	}

	@Test(dependsOnMethods = "createUser")
	public void modifyUser() {
		System.out.println("MODIFY USER");
	}

	@Test(enabled = true)
	public void deleteUser() {
		System.out.println("DELETE USER");
	}

}
