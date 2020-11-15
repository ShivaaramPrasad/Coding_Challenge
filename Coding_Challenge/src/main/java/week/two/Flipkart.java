package week.two;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	public static  WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.out.println("User Option is 2, So Invoking FF Browser");
		FirefoxOptions options_firfox = new FirefoxOptions();
		options_firfox.setProfile(new FirefoxProfile());
		options_firfox.addPreference("dom.webnotifications.enabled", false);
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(options_firfox);
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("Home Theaters",Keys.ENTER);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		String result_text = driver.findElement(By.xpath("//span[contains(text(),'Showing')]")).getText();
		System.out.println(result_text);
		String[] result = result_text.split(" ");
		int totalcount = Integer.parseInt(result[5].replaceAll("[^0-9]",""));
		System.out.println("Search Count:"+totalcount);

		WebElement rating = driver.findElement(By.xpath("//div[text()='4★ & above']"));
		JavascriptExecutor jse_option = (JavascriptExecutor)driver;
		jse_option.executeScript("arguments[0].scrollIntoView(true)", rating);
		jse_option.executeScript("arguments[0].click();", rating);
		Thread.sleep(3000);

		String filterresult_text = driver.findElement(By.xpath("//span[contains(text(),'Showing 1')]")).getText();
		System.out.println(filterresult_text);
		String[] filterresult = filterresult_text.split("of");
		String fc = filterresult[1].replaceAll("[0-9]","");
		int filtercount = Integer.parseInt(filterresult[1].replaceAll("[^0-9]",""));
		if(totalcount>filtercount)
			System.out.println("Search Count:"+filtercount);

		WebElement price = driver.findElement(By.xpath("//div[text()='Price -- High to Low']"));
		price.click();
		if(Integer.parseInt((price.getCssValue("font-weight"))) >= 700)
			System.out.println("Font weight is bold");
		else 
			System.out.println("Font weight is not bold");
		Thread.sleep(2000);

		String itemA_Price = driver.findElement(By.xpath("(//div[contains(text(),'₹')])[1]")).getText();
		String itemB_Price = driver.findElement(By.xpath("(//div[contains(text(),'₹')])[3]")).getText();

		String valuea = itemA_Price.replaceAll("[^0-9]","");
		String valueb = itemB_Price.replaceAll("[^0-9]", "");

		if(Integer.parseInt(valuea) > Integer.parseInt(valueb))
			System.out.println("Sorted by Price High to Low");
		else
			System.out.println("Not Sorted Properly");

		driver.findElement(By.xpath("//div[text()='Newest First']")).click();;
		Thread.sleep(2000);
		WebElement itemA = driver.findElement(By.xpath("(//a[contains(@class,'_2cLu-l')])[1]"));
		WebElement itemB = driver.findElement(By.xpath("(//a[contains(@class,'_2cLu-l')])[2]"));

		String itemA_name = itemA.getText().replace(".", "");
		String itemB_name = itemA.getText().replace(".", "");;

		Actions action_size = new Actions(driver);
		action_size.moveToElement(itemA).clickAndHold().pause(3).perform();
		driver.findElement(By.xpath("(//a[contains(@class,'_2cLu-l')])[1]//following::span[text()='Add to Compare'][1]")).click();
		action_size.moveToElement(itemB).clickAndHold().pause(3).perform();
		driver.findElement(By.xpath("(//a[contains(@class,'_2cLu-l')])[2]//following::span[text()='Add to Compare'][1]")).click();
		driver.findElement(By.xpath("//span[text()='COMPARE']")).click();
		Thread.sleep(2000);
		String item1 = driver.findElement(By.xpath("(//a[contains(@class,'_3YNWH1')])[1]")).getText();
		String item2 = driver.findElement(By.xpath("(//a[contains(@class,'_3YNWH1')])[2]")).getText();
		//if((item1.contains(itemA_name)) && (item2.equals(itemB_name)))
		System.out.println(item1+ " "+ item2);
		driver.close();
	}

}
