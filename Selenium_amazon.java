import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sel_Test9 {

	public WebDriver driver;

	@BeforeMethod
	public void before() {
		System.out.println("-------Testcase has started-------");
		System.setProperty("webdriver.chrome.driver", "C://Desktop//Amitabha//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testcase1() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id= 'twotabsearchtextbox']")).sendKeys("Apple Iphone 12 pro max",
				Keys.ENTER);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element= driver.findElement(By.xpath("//span[text()= 'New Apple iPhone 12 Pro Max (256GB) - Gold']"));
		js.executeScript("arguments[0].scrollIntoView()",
				element);
		element.click();
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//p[text()= '128GB']")));
		WebElement memory= driver.findElement(By.xpath("//p[text()= '128GB']"));
		memory.click();
		WebElement catagory = driver.findElement(By.xpath("//p[text()= 'iPhone 12 Pro Max with Magsafe Clear Case']"));
		catagory.click();
		Thread.sleep(2000);
		

	}

	@AfterMethod
	public void after() {
//		driver.quit();
		System.out.println("-------Testcase has ended--------");

	}

}
