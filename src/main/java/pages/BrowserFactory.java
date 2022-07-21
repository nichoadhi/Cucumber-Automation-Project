package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserFactory {

	public static WebDriver driver;
	String url;
	String browser;

	@Test
	public void init() {
		readConfig();

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public void readConfig() {
		try {
			// loading the config.properties file
			InputStream input = new FileInputStream("src/main/java/config/config.properties");
			Properties prop = new Properties();
			prop.load(input);

			// reading the config.properties file using the key
			url = prop.getProperty("url");
			browser = prop.getProperty("browser");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void teardown() {
		driver.close();
		driver.quit();
	}
}
