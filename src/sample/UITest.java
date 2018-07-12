package sample;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UITest { 
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();
 
   
  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    

	  }

@Test
	public void p_1() throws Exception {
		driver.get("http://cjmall.com");
		
		// 로그인 버튼 클릭
		driver.findElement(By.xpath(".//*[@id='header']/div[1]/div[5]/ul/li[1]/a/span")).click();
		System.out.println("로그인 버튼 클릭");
		
		//Enter enter = new Enter();
		Thread.sleep(3000);
		
		// 로그인 Text 체크
		if ("로그인".equals(driver.findElement(By.xpath(".//*[@id='content']/div[1]/h2")).getText())) {
			System.out.println("TC_1 Pass");
			assertTrue(true);
			return;
		} else {
			System.out.println("TC_1 Fail");
			assertTrue(false);
		}
		System.out.println("텍스트 체크");
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
