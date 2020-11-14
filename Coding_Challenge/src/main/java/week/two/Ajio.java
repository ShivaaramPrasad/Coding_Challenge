package week.two;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {


	public static  WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Launch the edge browser
		WebDriverManager.edgedriver().setup();
		EdgeOptions opt =new EdgeOptions();
		opt.addArguments("--disable-notifications");
		driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// load url www.redbus.in
		driver.get("https://www.ajio.com");

		WebElement women = driver.findElement(By.xpath("(//a[text()='WOMEN'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(women).perform();
		driver.findElement(By.xpath("(//span[text()='Shop by: '])[2]/following::a[contains(text(),'BRANDS')]")).click();
		WebElement Brand = driver.findElement(By.xpath("(//a[contains(text(),'BRANDS')])[2]/following::a"));
		List<WebElement> brands = driver.findElements(By.xpath("//div[@class='brand']"));
		for (WebElement eachEle : brands) {


			String brandText =eachEle.getText();
			int upper = 0, lower = 0;
			int maxLower=0; int maxUpper=0;


			for(int i = 0; i < brandText.length(); i++) 
			{ 
				char ch = brandText.charAt(i); 
				if (ch >= 'A' && ch <= 'Z') {
					maxUpper=upper;
				}
				else if (ch >= 'a' && ch <= 'z') { 
					maxLower=lower;
					System.out.println("Max Number of lower case"+brandText);
					driver.findElement(By.xpath("(//a[contains(text(),'BRANDS')])[2]/following::a[contains(text(),'"+brandText+"')]")).click();

				}
			}
			String itemsFound = driver.findElement(By.className("length")).getText();
			String[] itemNum=itemsFound.split(" ");
			System.out.println("The product of the size of the Mens Rectangular Sunglass is "+itemNum[0]);
			int firstValue=Integer.valueOf(itemNum[0]);
			driver.findElement(By.xpath("//span[text()='size & fit']/parent::div")).click();
			driver.findElement(By.xpath("//label[@for='S']")).click();
			String itemsFoundAgain = driver.findElement(By.className("length")).getText();
			String[] itemNumAgain=itemsFound.split(" ");
			System.out.println("The product of the size of the Mens Rectangular Sunglass is "+itemNumAgain[0]);

			int secondValue=Integer.valueOf(itemNumAgain[0]);

			if(firstValue>secondValue)
			{
				System.out.println("Reduced values"+secondValue);
			}

			WebElement allCategories =driver.findElement(By.xpath("//div[@class='filter-dropdown']//select[1]"));
			Select value_one = new Select(allCategories);
			List<WebElement> options_two=value_one.getOptions();
			//int count =options.size();
			value_one.selectByVisibleText("Discount");
			String text = driver.findElement(By.xpath("//span[@class='orginal-price']/following-sibling::span")).getText();
			if(text.contains("80")) {
				System.out.println("The Higher discount is shown first");
			}
			driver.close();
		}

	}
}

