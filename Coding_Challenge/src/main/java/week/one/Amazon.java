package week.one;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.time.format.DecimalStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import com.google.common.collect.Lists; 
import java.util.*; 
import java.util.stream.*; 


import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static <CultureInfo> void main(String[] args) throws InterruptedException {
		// Lunch  Chrome 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		//Load URL:
		//	    1. Login to https://www.amazon.in/

		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Search for costliest furniture");
		// Click Choose and Select Furniture
		driver.findElement(By.id("searchDropdownBox")).click();

		WebElement allCategories =driver.findElement(By.id("searchDropdownBox"));
		Select value_one = new Select(allCategories);
		List<WebElement> options_two=value_one.getOptions();
		//int count =options.size();
		value_one.selectByVisibleText("Furniture");

		// Type 'chairs for computer table' and Enter
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("chairs for computer table",Keys.ENTER);

		List<WebElement> price = driver.findElements(By.xpath("(//span[text()='Sponsored'])[2]/following::span[@class='a-price']"));

		List<Integer> aNum = new ArrayList<Integer>();

		for (WebElement webElement_sort : price) {
			int namesorted = Integer.parseInt(webElement_sort.getText().replaceAll("[^0-9]", ""));		
			aNum.add(namesorted);
			Collections.sort(aNum);
			Collections.reverse(aNum);

		}
		Integer costilestnum=aNum.get(0);
		System.out.println("Num costliest  "+costilestnum);
		
		Format df = new DecimalFormat("##,##,000");
		String formattedString = df.format(costilestnum);
		System.out.println(formattedString);
		
 		driver.findElement(By.xpath("//span[text()='"+formattedString+"']/preceding::i[2]")).click();
		String globalRatings = driver.findElement(By.xpath("//span[contains(text(),'global ratings')]")).getText();
		System.out.println(globalRatings+" for the costilest Furniture ");
		String globalRatingsText=globalRatings.replaceAll("[^0-9]", "");
		int globalRatingsNum =Integer.parseInt(globalRatingsText);
		String stars = driver.findElement(By.xpath("//span[text()='"+globalRatings+"']/following::a")).getText();
		String percenatage = driver.findElement(By.xpath("(//span[text()='"+globalRatings+"']/following::a)[3]")).getText();
		System.out.println(stars+" for the costilest furniture is "+percenatage);
		String percenatageText=percenatage.replaceAll("[^0-9]", "");
		int percenatageNum =Integer.parseInt(percenatageText);
		int cal=globalRatingsNum*percenatageNum/100;
		System.out.println("The costliest the Furniture "+stars+"* rating is "+percenatageNum+ "% of " +globalRatingsNum+"= "+cal);
        Thread.sleep(5000);
        driver.close();
	}
}