import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class loginTest {
	static WebDriver driver = new FirefoxDriver();

	@Before
	public void setUp() throws Exception {
		driver.get("http://store.demoqa.com/products-page/your-account/");
	}

	// ------------------------------------------------------------------------------------------------------
	// 1.As a user
	// I want to log in
	// So that I can access my shopping account
	// ------------------------------------------------------------------------------------------------------

	// Given empty username and password
	// When I try to login
	// Then I should receive an error message with "Please enter your username
	// and password."
	@Test
	public void userlogin1() {
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement errorMessage = driver.findElement(By.xpath("//*[@id='ajax_loginform']/p[1]/strong[1]"));
		assertEquals("ERROR", errorMessage.getText());
	}

	// Given non-empty username and empty password
	// When I try to login
	// Then I should receive an error message with "ERROR: The password field is
	// empty."
	@Test
	public void userlogin2() {
		WebElement userbox = driver.findElement(By.id("log"));
		userbox.sendKeys("whatever");
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement errorMessage = driver.findElement(By.xpath("//*[@id='ajax_loginform']/p[1]/strong[1]"));
		assertEquals("ERROR", errorMessage.getText());
	}

	// Given wrong username and wrong password
	// When I try to login
	// Then I should receive an error message with "ERROR: Invalid login
	// credentials."
	@Test
	public void userlogin3() {
		WebElement userbox = driver.findElement(By.id("log"));
		userbox.sendKeys("whatever");
		WebElement pwdbox = driver.findElement(By.id("pwd"));
		pwdbox.sendKeys("whatever");
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement errorMessage = driver.findElement(By.xpath("//*[@id='ajax_loginform']/p[1]/strong[1]"));
		assertEquals("ERROR", errorMessage.getText());
	}

}
