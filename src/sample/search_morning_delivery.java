package sample;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class search_morning_delivery { 
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
		
		String parentHandle = driver.getWindowHandle(); // 현재 윈도우를 부모핸들로 지정 
		driver.findElement(By.xpath("//*[@id=\"lnb\"]/ul/li[5]/a")).click(); //새벽배송조회

		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // 신규 윈도우를 찾으면 해당 윈도우로 핸들 스위칭  
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"frmStreetSearch\"]/label/input")).sendKeys("면목동");; //동 검색
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"frmStreetSearch\"]/input[5]")).click(); //검색버튼 클릭
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"streetList\"]/tr[1]/td[2]/p[1]/a")).click(); //검색 결과 클릭 
		Thread.sleep(1000);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
				
		driver.findElement(By.xpath("//*[@id=\"tablist\"]/ul/li[2]/a")).click(); //지번주소 검색 탭클릭
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"frmJibunSearch\"]/label/input")).sendKeys("동백동");; //동 검색
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"frmJibunSearch\"]/input[4]")).click(); //검색 버튼 클릭
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"jibunList\"]/tr[1]/td[2]/a")).click(); //검색 결과 클릭 
		Thread.sleep(1000);
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		
		driver.close(); // 현재 창 닫기 
		driver.switchTo().window(parentHandle); // 원래 윈도우 창으로 핸들 스위칭
			
		System.out.println("morming_delivery success");	
	
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