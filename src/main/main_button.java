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
 * Date : 2018-07-16
 * Subject : main
 * Name : TC_1
 * Scenario : 1.main 화면 각 버튼 동작 확인
 * Assertion :  버튼 동작 확인
 *
 */

public class main_button { 
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
		
		driver.findElement(By.xpath("//*[@id=\"header_wrap\"]/div/h1/a/img")).click(); //배민찬 로고 click
		
		//카테고리 이동
		driver.findElement(By.xpath("//*[@id=\"navi_wrap\"]/nav/ul/li[1]/a/span")).click(); //밑반찬 카테고리 click
		driver.findElement(By.xpath("//*[@id=\"navi_wrap\"]/nav/ul/li[2]/a/span")).click(); //국찌개 카테고리 click
		driver.findElement(By.xpath("//*[@id=\"navi_wrap\"]/nav/ul/li[3]/a/span")).click(); //메인반찬 카테고리 click
		driver.findElement(By.xpath("//*[@id=\"navi_wrap\"]/nav/ul/li[4]/a/span")).click(); //아이반찬 카테고리 click
		driver.findElement(By.xpath("//*[@id=\"navi_wrap\"]/nav/ul/li[5]/a/span")).click(); //정기식단 카테고리 click
		driver.findElement(By.xpath("//*[@id=\"navi_wrap\"]/nav/ul/li[6]/a/span")).click(); //신선간편 카테고리 click
		driver.findElement(By.xpath("//*[@id=\"navi_wrap\"]/nav/ul/li[7]/a/span")).click(); //간식 카테고리 click
		driver.findElement(By.xpath("//*[@id=\"navi_wrap\"]/nav/ul/li[8]/a/span")).click(); //브랜드관 카테고리 click
		
		//상단메뉴 이동
		driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[1]/a")).click(); //로그인
		driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[2]/a")).click(); //회원가입
		driver.navigate().back(); //뒤로가기
		driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[3]/a")).click(); //마이페이지
		driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[4]/a")).click(); //고객센터
		driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[5]/a")).click(); //새벽배송 지역검색
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[5]/a")).click(); // click some link that opens a new window

		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		} //code to do something on new window
		driver.findElement(By.xpath("//*[@id=\"tablist\"]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		driver.close(); // close newly opened window when done with it
		Thread.sleep(1000);
		driver.switchTo().window(parentHandle); // switch back to the original window
		
		driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[6]/a")).click(); //이벤트 게시판
		driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[7]/a")).click(); //장바구니
		driver.findElement(By.xpath("//*[@id=\"header_wrap\"]/div/ul/li[1]/a/img")).click(); //베스트
		driver.findElement(By.xpath("//*[@id=\"header_wrap\"]/div/ul/li[2]/a/img")).click(); //알뜰쇼핑		
		
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
