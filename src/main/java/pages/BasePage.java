package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BasePage {

	public void screenshotTake(WebDriver driver) {
		//these three lines of code actually creates a meaningful label(name) for our screenshot
		SimpleDateFormat formatobj = new SimpleDateFormat("MMMMM.dd.yyyy hh:mm aaa");
		Date date = new Date();
		String label =formatobj.format(date);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File destination =new File(System.getProperty("user.dir") + "/screenshot/" + label + ".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
