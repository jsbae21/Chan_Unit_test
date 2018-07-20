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
 * Name : review_003
 * Scenario : 1.로그인
 * 			  2.무나물 검색
 * 			  3.상품상세 진입 > 내가 작성 한 후기 수정페이지 진입 (후기에 사진 등록)
 * 			  4.사진 삭제 후 수정 완료 버튼 Tap
 * 			  5.pop-up check
 *              (포토후기는 1장 이상의 사진을 첨부해야 됩니다. 사진 첨부 후 다시 시도해 주세요.)
 * Assertion :  Login success
				Search success
				Open a review page success
				pop-up check success
 *
 */

public class review_003 { 
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
		
		//리뷰 페이지 진입  **condition : 1개의 사진 추가된 상태**
		driver.findElement(By.xpath("//*[@id=\"product_detail_bar\"]/div/ul/li[2]/a")).click(); //후기탭
		Thread.sleep(1500); 
		driver.findElement(By.xpath("//*[@id=\"detail_opinion\"]/div/div/div/div/div[3]/div/section[1]/div[1]/div[2]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		System.out.println("Open a review page success");
		
		// Delete a photo
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[4]/div/div/div/div[1]/div/a")).click();
		System.out.println("Delete photos success");
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
		
		// Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		  		
        System.out.println(alertMessage); // Displaying alert message	 
        Thread.sleep(1000);
        		
        // Accepting alert		
        alert.accept();	
        Thread.sleep(2000);
		System.out.println("pop-up check success");
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

