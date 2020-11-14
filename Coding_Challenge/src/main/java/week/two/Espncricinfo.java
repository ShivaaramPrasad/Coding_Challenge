package week.two;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Espncricinfo {

	public static  RemoteWebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("--start-fullscreen");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		driver.get("https://www.espncricinfo.com/");
		
		driver.findElement(By.xpath("//a[@class='sprite close']")).click();
		Thread.sleep(12000);
		
		WebDriverWait wait_one = new WebDriverWait(driver,5);
		wait_one.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='IPL 2020']")));
		driver.findElement(By.xpath("//span[text()='IPL 2020']")).click();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String RESULT_FILENAME = null;
		FileUtils.copyFile(scrFile, new File(RESULT_FILENAME));

		
		

	}

}
