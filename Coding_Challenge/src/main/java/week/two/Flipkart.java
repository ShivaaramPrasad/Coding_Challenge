package week.two;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	public static  WebDriver driver;

	public static void main(String[] args) {
		
		System.out.println("User Option is 2, So Invoking FF Browser");
		FirefoxOptions options_firfox = new FirefoxOptions();
		options_firfox.setProfile(new FirefoxProfile());
		options_firfox.addPreference("dom.webnotifications.enabled", false);
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(options_firfox);
		
		driver.get("https://www.flipkart.com/");
	}

}
