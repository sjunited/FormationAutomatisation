package pack1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
	ChromeDriver driver;
	
	
  @Test
  public void advancedSearch() {
	  driver.get("https://www.cafr.ebay.ca/");
	  WebElement advance = driver.findElement(By.id("gh-as-a"));
	  advance.click();
	  String expectedTitle = "Recherche approfondie";
	  String advancedTitle = driver.getTitle();
	  Assert.assertEquals(expectedTitle, advancedTitle, "Validate advanced title");
	  
	  String expectedUrl = "https://www.cafr.ebay.ca/sch/ebayadvsearch";
	  String advancedUrl = driver.getCurrentUrl();
	  Assert.assertEquals(advancedUrl,expectedUrl, "Validate advanced url");
	  
	  
	  
  }
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }

 
@AfterClass
  public void afterClass() throws InterruptedException {
	Thread.sleep(3000);
	driver.close();
  }

}
