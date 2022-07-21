package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ToDoListPage extends BasePage {

	WebDriver driver;
	
	public ToDoListPage(WebDriver driver) {
		this.driver= driver;
	}
	
	//element list
	@FindBy(how= How.XPATH ,using= "//button[@onclick='myFunctionSky()']") WebElement SKYBLUE_BUTTON_ELEMENT;
	@FindBy(how= How.XPATH ,using= "//button[@onclick='myFunctionWhite()']") WebElement WHITE_BUTTON_ELEMENT;
	
	//interactable methods
	
	public void clickOnSkyBlueButton() {
		SKYBLUE_BUTTON_ELEMENT.click();
		System.out.println("Background color is now Sky Blue");
	}
	
	public void validateBackgroundColorIsSkyBlue() {
		String colorBlueCSSValue = driver.findElement(By.xpath("//body")).getCssValue("background-color");
		String colorBlue = Color.fromString(colorBlueCSSValue).asHex();
		System.out.println(colorBlue);
		
		Assert.assertEquals(colorBlue, "#87ceeb", "Color value mismatch");
		screenshotTake(driver);
		
	}
	
	public void clickOnWhiteButton() {
		WHITE_BUTTON_ELEMENT.click();
		System.out.println("Background color is now White");
	}
	
	public void validateBackgroundColorIsWhite() {
		String colorWhiteCSSValue=driver.findElement(By.xpath("//body")).getCssValue("background-color");
		String colorWhite = Color.fromString(colorWhiteCSSValue).asHex();
		System.out.println(colorWhite);
		
		Assert.assertEquals(colorWhite, "#ffffff", "Color value mismatch");
		screenshotTake(driver);
	}
}
