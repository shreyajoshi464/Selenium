package Code;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenClinic {
	WebDriver dr;
	String url="http://openclinic.sourceforge.net/openclinic/home/index.php";
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.get(url);
		dr.manage().window().maximize();
	
	}

	@After
	public void tearDown() throws Exception {
		dr.quit();
	}

	@Test
	public void test() {
		String NewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		dr.findElement(By.linkText("Medical Records")).sendKeys(NewTab);
		
		Set<String> WindowHandle = dr.getWindowHandles();
		for (String T:WindowHandle){
			dr.switchTo().window(T);
		}
		dr.findElement(By.linkText("Search Patient")).click();
		
		WebElement WL= dr.findElement(By.id("Search_type"));
		Select W = new Select(WL);
		W.selectByVisibleText("First Name");
		
		dr.findElement(By.id("Search Patient")).click();
		
	}

}
