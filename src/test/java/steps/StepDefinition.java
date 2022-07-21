package steps;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BrowserFactory;
import pages.ToDoListPage;

public class StepDefinition extends BrowserFactory{

	ToDoListPage page;
	
	@Before
	public void beforeRun() {
		init();
		page = PageFactory.initElements(driver, ToDoListPage.class);
	}
	
	@Given("^User is on the Techfios automation project testing page$")
	public void user_is_on_the_Techfios_automation_project_testing_page() {
	   
	}

	@Given("^Set SkyBlue Background button exists$")
	public void set_SkyBlue_Background_button_exists() {
	   
	}

	@Given("^Set White Background button exists$")
	public void set_White_Background_button_exists() {
	
	}

	@When("^User clicks on the: Set SkyBlue Background button$")
	public void user_clicks_on_the_Set_SkyBlue_Background_button() {
		page.clickOnSkyBlueButton();
	}

	@Then("^The background color will change to sky blue$")
	public void the_background_color_will_change_to_sky_blue() {
		page.validateBackgroundColorIsSkyBlue();
	}

	@When("^User clicks on the: Set White Background button$")
	public void user_clicks_on_the_Set_White_Background_button() {
		page.clickOnWhiteButton();
	}

	@Then("^The background color will change to white$")
	public void the_background_color_will_change_to_white() {
		page.validateBackgroundColorIsWhite();
	}
	
	@After
	public void afterRun() {
		teardown();
	}
}
