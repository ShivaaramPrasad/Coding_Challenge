package week.one;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class redbus {
	public static  RemoteWebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//Launch the edge browser
		WebDriverManager.edgedriver().setup();
		EdgeOptions opt =new EdgeOptions();
		opt.addArguments("--disable-notifications");
		driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// load url www.redbus.in
		driver.get("https://www.redbus.in/");
		//Print the edge browser version 
		String browserVersion = driver.getCapabilities().getVersion();
		System.out.println("Browser Version "+browserVersion);
		//Enter To as "Bangalore(All Loaction) and Shift+TAB"
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		Thread.sleep(5000);
		driver.findElementById("dest").sendKeys("+ {TAB}");

		//Enter To as "Chennai(All Loaction) and Shift+TAB"
		driver.findElement(By.id("src")).sendKeys("Chennai");
		Thread.sleep(5000);

		//Choose Date as first monday of next month
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//td[@class='next']")).click();

		boolean row1MondayStatus = driver.findElementByXPath("//table//tr[3]/td[@class='empty day']").isDisplayed();
		if(row1MondayStatus) {
			driver.findElement(By.xpath("//table//tr[4]/td[@class='wd day'][1]")).click();
		}else {
			driver.findElement(By.xpath("//table//tr[3]/td[@class='wd day'][1]")).click();
		}		
		// Click Search Buses
		driver.findElement(By.id("search_btn")).click();
		
		//Print total number of displayed buses
		String buses = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();

		System.out.println(buses+"found on web");

		driver.findElement(By.xpath("//i[@class='icon icon-close c-fs']")).click();
		System.out.println("List of buses shown");
		List<WebElement> busList = driver.findElements(By.xpath("//span[text()='found']/following::div[contains(@class,'travels lh-24')]"));
		int size=busList.size();
		System.out.println(""+size);

		for( WebElement product : busList){
			System.out.println(product.getText());
		}
		driver.close();
	}

}
