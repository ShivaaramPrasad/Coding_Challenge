package week.one;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day6CodingChallenge {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		System.out.println(driver.manage().window().getSize());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		
		WebElement eleSearchBox = driver.findElementByClassName("desktop-searchBar");
		eleSearchBox.sendKeys("Sunglass");
		eleSearchBox.sendKeys(Keys.ENTER);

		driver.findElementByXPath("//input[@placeholder='Search for Brand']/following-sibling::span").click();
		driver.findElementByXPath("//input[@placeholder='Search for Brand']").sendKeys("Polaroid");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElementByXPath("//input[@type='checkbox'][@value='Polaroid']"));
		
		
		
		List<WebElement> eleMenRecGlass = driver.findElementsByXPath("//ul[@class='results-base']/li//descendant::a[contains(@href,'polaroid-men-rectangle')]");
		System.out.println("Total no of Polaroid Mens Rectangle Glasses is: "+eleMenRecGlass.size());
		System.out.println(" Size of the Glasses are below:");
		for (int i = 1; i <= eleMenRecGlass.size(); i++) {
			System.out.println(js.executeScript("return arguments[0].innerHTML;", driver.findElementByXPath("(//ul[@class='results-base']/li//descendant::a[contains(@href,'polaroid-men-rectangle')]//descendant::h4[@class='product-sizes'])["+i+"]/span")).toString());
		}
		// Verified till the above steps thereafter site down
		WebElement viewSimilar = driver.findElementByXPath(("//span[contains(@class,'myntraweb-sprite image-grid-similarColorsIcon')]"));
		Actions ac = new Actions(driver);
		
		ac.moveToElement(viewSimilar).build().perform();
		driver.findElementByXPath(("//span[text()='VIEW SIMILAR']")).click();
		List<WebElement> similarProduct = driver.findElementsByXPath(("//div[text()='Similar Products']/following::h4"));
		int NumSimPro=similarProduct.size();
		System.out.println("Number of Simailar Product "+NumSimPro);
		driver.close();
		
		
	}

}
