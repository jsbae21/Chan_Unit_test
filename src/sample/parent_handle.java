package sample;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class parent_handle { 
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();
 
   
  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    

	  }

@Test
	public void p_001() throws Exception {
		driver.get("https://alpha-www.baeminfresh.com/");
		
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[5]/a")).click(); // click some link that opens a new window

		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		} //code to do something on new window
		driver.findElement(By.xpath("//*[@id=\"tablist\"]/ul/li[2]/a")).click();
		Thread.sleep(3000);
		driver.close(); // close newly opened window when done with it
		Thread.sleep(3000);
		driver.switchTo().window(parentHandle); // switch back to the original window
		
			
		System.out.println("main success");	
	
}

@After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

	public boolean existElement(WebDriver wd, By by, String meaning) {
		WebDriverWait wait = new WebDriverWait(wd, 2);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));

		} catch (TimeoutException e) {

			return false;
		}
		return true;
	}
	 
}
