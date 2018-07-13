package contents;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * Date : 2018-07-13
 * Subject : review
 * Name : review_004
 * Scenario : 1.로그인
 * 			  2.무나물 검색
 * 			  3.상품상세 진입 
 * 			  4.등록한 후기 삭제 
 * Assertion :  Login success
			    Search success
				후기를 삭제할까요?
				pop-up check success
				Delete a review success
 *
 */

public class review_004 { 
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
		driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"member_id\"]")).sendKeys("baelong7@naver.com"); //아이디 입력 
		driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("q1w2e3r4t5"); //패스워드 입력  
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/form/fieldset/button")).click(); //로그인 버튼 클릭 
		System.out.println("Login success");
		
		//무나물 검색 후 선택
		driver.findElement(By.xpath("//*[@id=\"search_str\"]")).sendKeys("무나물");
		driver.findElement(By.xpath("//*[@id=\"header_wrap\"]/div/form/button")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"products\"]/li[1]/div/a")).click();
		Thread.sleep(1500);
		System.out.println("Search success");
		
		//후기 영역 진입  
		driver.findElement(By.xpath("//*[@id=\"product_detail_bar\"]/div/ul/li[2]/a")).click(); //후기탭
		Thread.sleep(1500); 
		driver.findElement(By.xpath("//*[@id=\"detail_opinion\"]/div/div/div/div/div[3]/div/section[1]/div[1]/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1500);
		
		// Switching to Alert        
        driver.switchTo().alert();		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		  		
        System.out.println(alertMessage); // Displaying alert message (후기를 삭제할까요?)	 
        Thread.sleep(1000);
        // 취소 Tap
        driver.switchTo().alert().dismiss();		
        driver.findElement(By.xpath("//*[@id=\"detail_opinion\"]/div/div/div/div/div[3]/div/section[1]/div[1]/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1500);
        // 확인 Tap	
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
		System.out.println("pop-up check success");
		
		driver.navigate().refresh();
		System.out.println("Delete a review success");
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

