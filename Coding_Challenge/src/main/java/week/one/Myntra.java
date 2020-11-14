package week.one;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static  RemoteWebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Launch the Incognito Chrome Browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//Print the window dimensions 
		Dimension size = driver.manage().window().getSize();
		System.out.println("Dimension of the window "+size );
		// Go to https://www.myntra.com/
		driver.get("https://www.myntra.com/");

		driver.findElement(By.tagName("input")).sendKeys("Sunglasses",Keys.ENTER);

		driver.findElement(By.xpath("(//span[text()='Brand']/following-sibling::div)[2]")).click();
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Polaroid");	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']//div[1]")).click();	
		driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]")).click();
		driver.findElement(By.xpath("//label[text()='Men']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(5000);

		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(5000);

		WebElement firstProduct = driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]"));
		Actions actionProvider = new Actions(driver);
		// Performs mouse move action onto the element
		actionProvider.moveToElement(firstProduct).build().perform();
		String text = driver.findElement(By.xpath("//h4[text()='Sizes: ']")).getText();
		String[] sizes=text.split(" ");
		System.out.println("The product of the size of the Mens Rectangular Sunglass is "+sizes[1]);

		WebElement viewSimilar = driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite image-grid-similarColorsIcon')]"));
		Actions actionProvider1 = new Actions(driver);
		// Performs mouse move action onto the element
		actionProvider1.moveToElement(viewSimilar).build().perform();
		driver.findElement(By.xpath("//span[text()='VIEW SIMILAR']")).click();
		Thread.sleep(5000);
		List<WebElement> similarProduct = driver.findElements(By.xpath("//div[text()='Similar Products']/following::h4"));
		int NumSimPro=similarProduct.size();
		System.out.println("Number of Simailar Product "+NumSimPro);
		//driver.close();
	}		

}
