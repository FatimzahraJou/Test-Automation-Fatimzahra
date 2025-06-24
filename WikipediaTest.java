import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class WikipediaTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe") ;
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
        
		
	
        /*WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Selenium (software)");
        driver.findElement(By.name("search")).submit() ;*/
    
        WebElement SearchInput = driver.findElement(By.id("js-lang-list-button")) ;
        driver.findElement(RelativeLocator.with(By.tagName("input")).above(SearchInput)).sendKeys("Selenium (software)") ;
        driver.findElement(By.name("search")).submit();
        
        Point position = driver.manage().window().getPosition() ;
        System.out.println(position.getX());
        System.out.println(position.getY());
        driver.manage().window().setPosition(new Point(100, 140)) ;
        File scrFile = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) ;
        FileUtils.copyFile(scrFile , new File ("./Capture.PNG")) ;
        
        driver.manage().window().maximize();
        System.out.println("Title : " + driver.getTitle());

        Thread.sleep(9000);
        
        driver.quit();
        

	}

}
