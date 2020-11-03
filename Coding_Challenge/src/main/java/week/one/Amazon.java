package week.one;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {
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
				
				List<String> a = new ArrayList<String>();

				for (WebElement webElement_sort : price) {
					String namesorted = webElement_sort.getText().replaceAll("[^0-9]", "").replaceAll(" ", "");
					a.add(namesorted);
					Collections.sort(a);
					Collections.reverse(a);

				}
				System.out.println("The costliest price of the Furniture ₹"+a.get(0)); 

				}

	}


