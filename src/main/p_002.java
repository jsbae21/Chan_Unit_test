package main;


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
 * Subject : 메인페이지
 * Name : TC_001
 * Scenario : 1. 김 검색
 *            2. 페이지 수 많은 경우 다음페이지 Tap
 *            3. 띄어쓰기 (무  나  물)
 *            4. 김& 검색
 *            5. 김& 검색결과
 *
 *result :  1.김 검색 Pass
			2.다음페이지 Tap
			3.무나물 검색 Pass
			4.김& 검색 Pass
			5.0건 표시 Pass
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
	public void p_002() throws Exception {
	driver.get("https://alpha-www.baeminfresh.com/");
	
	driver.findElement(By.xpath("//*[@id=\"search_str\"]")).click(); //search click
	driver.findElement(By.id("search_str")).click();
	driver.findElement(By.id("search_str")).clear();
	driver.findElement(By.id("search_str")).sendKeys("김");
	driver.findElement(By.xpath("//*[@id=\"header_wrap\"]/div/form/button")).click(); //button click
	if ("김".equals(driver.findElement(By.xpath("//*[@id=\"searchResult\"]/p/strong[1]")).getText())) {
		System.out.println("김 검색 Pass");
		assertTrue(true);
	} else {
		System.out.println("김 검색 Fail");
		assertTrue(false);
		}
	if( driver.findElements(By.xpath("//*[@id=\"container\"]/div/div[2]")).isEmpty()){
		System.out.println("페이지 노출 안됨");}
	else{
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/a")).click();
		System.out.println("다음페이지 Tap");}
		Thread.sleep(2000);
		
	driver.findElement(By.xpath("//*[@id=\"search_str\"]")).click(); //search click
	driver.findElement(By.id("search_str")).click();
	driver.findElement(By.id("search_str")).clear();
	driver.findElement(By.id("search_str")).sendKeys("무  나  물");
	driver.findElement(By.xpath("//*[@id=\"header_wrap\"]/div/form/button")).click(); //button click
	if ("무나물".equals(driver.findElement(By.xpath("//*[@id=\"searchResult\"]/p/strong[1]")).getText())) {
		System.out.println("무나물 검색 Pass");
		assertTrue(true);
	} else {
		System.out.println("무나물 검색 Fail");
		assertTrue(false);
		}
	
	driver.findElement(By.xpath("//*[@id=\"search_str\"]")).click(); //search click
	driver.findElement(By.id("search_str")).click();
	driver.findElement(By.id("search_str")).clear();
	driver.findElement(By.id("search_str")).sendKeys("김&");
	driver.findElement(By.xpath("//*[@id=\"header_wrap\"]/div/form/button")).click(); //button click
	if ("김&".equals(driver.findElement(By.xpath("//*[@id=\"searchResult\"]/p/strong[1]")).getText())) {
		System.out.println("김& 검색 Pass");
		assertTrue(true);
	} else {
		System.out.println("김& 검색 Fail");
		assertTrue(false);
		}
	if ("0".equals(driver.findElement(By.xpath("//*[@id=\"searchResult\"]/p/strong[2]")).getText())) {
		System.out.println("0건 표시 Pass");
		assertTrue(true);
	} else {
		System.out.println("0건 표시 Fail");
		assertTrue(false);
		}
	
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
