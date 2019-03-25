package login;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * Date : 2018-07-27
 * Subject : 회원
 * Name : TC_003
 * Scenario : 회원가입 페이지 이동
 *            1. 상단 > 회원가입 Tap
 *            2. 상단 > 로그인 > 회원가입 Tap
 * Result : 1. 회원가입 페이지 이동1 Pass
	    2. 회원가입 페이지 이동2 Pass 
 *
 */

public class p_002 { 
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
	driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[2]/a")).click(); //회원가입 click
	System.out.println("회원가입 페이지 이동1 Pass");
	driver.navigate().back(); //뒤로가기
	driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[1]/a")).click(); //로그인
	driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/a[3]")).click(); //회원가입 페이지 이동
	System.out.println("회원가입 페이지 이동2 Pass");
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
