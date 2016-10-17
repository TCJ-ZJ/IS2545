import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.jna.platform.win32.OaIdl.VARDESC;

public class redirectTest {
	
	static WebDriver driver = new FirefoxDriver();
	@Before
	public void setUp() throws Exception {
		driver.get("http://store.demoqa.com/");
	}
	// ------------------------------------------------------------------------------------------------------
	// 3.As a user
	// I want to click the button
	// So that I can redirect to the certain page I want;
	// ------------------------------------------------------------------------------------------------------

	// Given that I'm on the main page
	// When I click the "checkout" button
	// Then I should redirect to the checkout page
	@Test
	public void checkoutButton() {
		WebElement button = driver.findElement(By.className("cart_icon"));
		button.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement newPage = driver.findElement(By.cssSelector("h1"));
		assertEquals("Checkout", newPage.getText());
	}
	// Given that I'm on the main page
	// When I click the image button
	// Then I should redirect to the product page with certain product
	// information[]
	@Test
	public void infoButton() {
		WebElement button=driver.findElement(By.xpath("//*[@id='footer']/section[2]/ul/li[3]/a[2]"));
		WebElement info=button.findElement(By.tagName("img"));
		String k = info.getAttribute("title");
		button.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement newPage = driver.findElement(By.cssSelector("h1"));
		assertEquals(k, newPage.getText());
	}
	
	// Given that I'm on the product info page
	// When I click "My account" button
	// Then I should redirect to the account page
	@Test
	public void AccountButton() {
		WebElement button=driver.findElement(By.className("account_icon"));
		button.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement newPage = driver.findElement(By.cssSelector("h1"));
		assertEquals("Your Account", newPage.getText());
	}
}
