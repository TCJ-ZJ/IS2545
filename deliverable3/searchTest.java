import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class searchTest {
	static WebDriver driver = new FirefoxDriver();
	@Before
	public void setUp() throws Exception {
		driver.get("http://store.demoqa.com/");
	}
	  	// ------------------------------------------------------------------------------------------------------
		// 2.As a user 
		//   I want to search the items I want to buy
		//   So that I can get the items list;
		// ------------------------------------------------------------------------------------------------------
		
		// Given an specific item name that exist in this website
		// When I try to search
		// Then I should get a list with the certain item;
	@Test
	public void searchSpecificItem() {
		WebElement searchBox = driver.findElement(By.className("search"));
		searchBox.sendKeys("Apple TV");
		searchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement title = driver.findElement(By.xpath("//*[@id='grid_view_products_page_container']/div/div/div[2]/h2/a[1]"));
		assertEquals("Apple TV", title.getText());
	}
		
	
	
		
		// Given an item name that not exist in this website
		// When I try to search
		// Then I should receive an error message with "Sorry, but nothing matched your search criteria. Please try again with some different keywords."
	@Test
	public void searchNoExsit() {
		WebElement searchBox = driver.findElement(By.className("search"));
		searchBox.sendKeys("nothing");
		searchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement title = driver.findElement(By.xpath("//*[@id='content']/p[1]"));
		assertEquals("Sorry, but nothing matched your search criteria. Please try again with some different keywords.", title.getText());
	}
	
	// Given an item name that match multiple items;
	// When I try to search
	// Then I should get a list with the all matched items;
	@Test
	public void searchMultipleItems() {
		WebElement searchBox = driver.findElement(By.className("search"));
		searchBox.sendKeys("Apple");
		searchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> titles = driver.findElements(By.className("grid_more_info"));
		assertTrue(titles.size() > 1);
	}

}
