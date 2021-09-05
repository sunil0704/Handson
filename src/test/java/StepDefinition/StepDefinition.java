package StepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver;

	@Before
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com/samples/basiccontact.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^Verify myContactForm Page is open$")
	public void verify_my_contact_form_page_is_open() {
		driver.get("https://www.mycontactform.com/samples/basiccontact.php");
		Assert.assertEquals("Basic Contact Form - myContactForm.com", driver.getTitle());
	}

	@Then("^Enter Your Name \"(.*)\"$")
	public void enter_your_name(String str) {

		driver.findElement(By.name("q[1]")).sendKeys(str);
	}

	@Then("^Enter valid email address \"(.*)\"$")
	public void enter_valid_email_address(String str1) {

		driver.findElement(By.name("email")).sendKeys(str1);
	}

	@Then("^Enter message in the Message Textbox \"(.*)\"$")
	public void message_in_the_Message(String str3) {
		driver.findElement(By.name("q[2]")).sendKeys(str3);

	}

	@Then("^submit form$")
	public void submit_form() {
		driver.findElement(By.name("submit")).click();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
