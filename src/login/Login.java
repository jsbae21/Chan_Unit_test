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
 * Date : 2018-06-25
 * Subject : 로그인 
 * Name : TC_1
 * Scenario : validation
 * Assertion : 로그인 
 *
 */

public class Login { 
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
		driver.get("https://www.baeminchan.com/");
		driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[1]/a")).click();
		
		//ID/PW 미입력
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/form/fieldset/button")).click(); //로그인 버튼 클릭 
		driver.switchTo().alert().dismiss();
		
		//Only ID
		driver.findElement(By.xpath("//*[@id=\"member_id\"]")).sendKeys("baelong7@naver.com");
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/form/fieldset/button")).click();
		driver.switchTo().alert().dismiss();
		
		//Only PW
		driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("q1w2e3r4t5");
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/form/fieldset/button")).click();
		driver.switchTo().alert().dismiss();
		
		//correct ID/ incorrect PW
		driver.findElement(By.xpath("//*[@id=\"member_id\"]")).sendKeys("baelong7@naver.com"); //아이디 입력 
		driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("aaaaaaa"); //패스워드 입력  
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/form/fieldset/button")).click(); //로그인 버튼 클릭
		driver.switchTo().alert().dismiss();
		
		//incorrect ID/ correct PW
		driver.findElement(By.xpath("//*[@id=\"member_id\"]")).sendKeys("abc@naver.com"); //아이디 입력 
		driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("q1w2e3r4t5"); //패스워드 입력  
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/form/fieldset/button")).click(); //로그인 버튼 클릭
		driver.switchTo().alert().dismiss();
		
		//정상 경로
		driver.findElement(By.xpath("//*[@id=\"member_id\"]")).sendKeys("baelong7@naver.com"); //아이디 입력 
		driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("q1w2e3r4t5"); //패스워드 입력  
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/form/fieldset/button")).click(); //로그인 버튼 클릭 
		System.out.println("Login success");
	
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
