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
 * Date : 2018-07-12
 * Subject : review
 * Name : TC_1
 * Scenario : 1.무나물 구매이력 O
 *            2.search > 무나물
 *            3.후기작성
 *            4.validation 후 등록
 * Assertion :  Login success
				Search success
				Open a review page success
				별점 TC_1 Pass
				별점 text 체크 success
				맛 TC_1 Pass
				양 TC_1 Pass
				가격 TC_1 Pass
				평가 text 체크 success
				내용 TC_1 Pass
				내용 TC_2 Pass
				review validation success
 *
 */

public class review { 
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
		
		//리뷰 페이지 진입
		driver.findElement(By.xpath("//*[@id=\"product_detail_bar\"]/div/ul/li[2]/a")).click(); //후기탭
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"detail_opinion\"]/div/div/div/div/div[2]/div[2]/span/a")).click(); // 상품 후기 작성 click
		Thread.sleep(2000);
		System.out.println("Open a review page success");
		
		// 별점 Text Check
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
		if ("별점을 선택해 주세요".equals(driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[1]/div[1]/div")).getText())) {
			System.out.println("별점 TC_1 Pass");
			assertTrue(true);
		} else {
			System.out.println("별점 TC_1 Fail");
			assertTrue(false);
			}
		System.out.println("별점 text 체크 success");
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[1]/div/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[1]/div/span[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[1]/div/span[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[1]/div/span[7]")).click();
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[1]/div/span[9]")).click();
		Thread.sleep(1500);
		
		//평가 Text Check
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
		if ("상품을 평가해 주세요".equals(driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[2]/div/div")).getText())) {
			System.out.println("맛 TC_1 Pass");
			assertTrue(true);
		} else {
			System.out.println("맛 TC_1 Fail");
			assertTrue(false);
			}
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[2]/dl/div[1]/dd[1]/label")).click(); //별로에요
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[2]/dl/div[1]/dd[2]/label")).click(); //괜찮아요
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[2]/dl/div[1]/dd[3]/label")).click(); //괜찮아요
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
		if ("상품을 평가해 주세요".equals(driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[2]/div/div")).getText())) {
			System.out.println("양 TC_1 Pass");
			assertTrue(true);
		} else {
			System.out.println("양 TC_1 Fail");
			assertTrue(false);
			}
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[2]/dl/div[2]/dd[1]/label")).click(); //부족해요
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[2]/dl/div[2]/dd[2]/label")).click(); //적당해요
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[2]/dl/div[2]/dd[3]/label")).click(); //넉넉해요
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
		if ("상품을 평가해 주세요".equals(driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[2]/div/div")).getText())) {
			System.out.println("가격 TC_1 Pass");
			assertTrue(true);
		} else {
			System.out.println("가격 TC_1 Fail");
			assertTrue(false);
			}
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[2]/dl/div[3]/dd[1]/label")).click(); //비싸요
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[2]/dl/div[3]/dd[2]/label")).click(); //적당해요
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[2]/dl/div[3]/dd[3]/label")).click(); //저렴해요
		Thread.sleep(1500);
		System.out.println("평가 text 체크 success");
		
		//내용 Text Check
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
		if ("내용을 입력해 주세요".equals(driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[3]/div[1]/div")).getText())) {
			System.out.println("내용 TC_1 Pass");
			assertTrue(true);
		} else {
			System.out.println("내용 TC_1 Fail");
			assertTrue(false);
			}
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[3]/div[2]/div/textarea")).sendKeys("후기 자동화 입력"); //9글자
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
		if ("10자 이상 입력해 주세요".equals(driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[3]/div[1]/div")).getText())) {
			System.out.println("내용 TC_2 Pass");
			assertTrue(true);
		} else {
			System.out.println("내용 TC_2 Fail");
			assertTrue(false);
			}
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//*[@id=\"foobar\"]/div/div/div[3]/div[2]/div/textarea")).sendKeys("입니다"); //12글자 완료
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
		Thread.sleep(2000);
		System.out.println("review validation success");
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

