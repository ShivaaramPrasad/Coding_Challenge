package week.one;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2CodingChallenge {
	public static RemoteWebDriver driver;
	public static void main(String[] args) {
		// Chrome Browser Setup
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		// Launch the Amazon Website
		driver.get("https://www.amazon.in/");

		WebElement elementCategoryDropdown = driver.findElementByXPath("//select[@title='Search in']");
		Select selCategory = new Select(elementCategoryDropdown);
		selCategory.selectByVisibleText("Furniture");

		driver.findElementById("twotabsearchtextbox").sendKeys("chairs for computer table");
		driver.findElementByXPath("//input[@type='submit'][@value='Go']").click();

		List<WebElement> elementPrice = driver.findElementsByXPath("//div[@data-component-type='s-search-result']//descendant::span[@class='a-price-whole']");
		
		Integer[] priceList = new Integer[elementPrice.size()];
		for(int i=0;i<elementPrice.size();i++ ) {
			if(((elementPrice.get(i).getText()) != null) && (elementPrice.get(i).getText()).length() > 0 ) {
				priceList[i] = Integer.parseInt((elementPrice.get(i).getText()).replaceAll("[^0-9]", "").replaceAll(" ", ""));
			}
		}
		
		Arrays.sort(priceList,Collections.reverseOrder()); 
		
		System.out.println("Heighest Price Value is: "+priceList[0]);
		
		List<WebElement> elementPrice1 = driver.findElementsByXPath("//div[@data-component-type='s-search-result']//descendant::span[@class='a-price-whole']");
		List<WebElement> elementRating = driver.findElementsByXPath("//div[@data-component-type='s-search-result']//descendant::a[contains(@class,'a-popover-trigger')]");
		for(int i=0;i<elementPrice.size();i++ ) {
			if(((elementPrice.get(i).getText()) != null) && (elementPrice1.get(i).getText()).length() > 0 ) {
				if(priceList[0] == Integer.parseInt((elementPrice1.get(i).getText()).replaceAll("[^0-9]", "").replaceAll(" ", ""))) {
					
					
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();",elementRating.get(i));
										
					String globalRatingText = driver.findElementByXPath("//span[contains(text(),'global ratings')]").getText();
					int globalRatingCount = Integer.parseInt(globalRatingText.replaceAll("[^0-9]", ""));
					String ratingPercentage = driver.findElementByXPath("(//a[contains(@title,'reviews have 5 star')][@class='a-link-normal'])[2]").getText();
					int percentageValue = Integer.parseInt(ratingPercentage.replaceAll("[^0-9]", "").trim());
					int ratingFinalValue=(globalRatingCount*percentageValue)/100;
					
					System.out.println("Final 5 Star Rating Value is: "+ratingFinalValue);
					break;
				}
				
			}
		}
		

	}

}
