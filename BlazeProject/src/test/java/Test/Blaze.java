package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class Blaze {

	WebDriver w;
	
	SoftAssert st;

	@BeforeTest
	public void preCondition_TC11() {

		String projectPath = System.getProperty("user.dir");
		String ChromeFile = "C:\\Users\\paurn\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromeFile);
	}

	@Test(priority = 0, description = "TC11-1:To validate the page Title")
	public void pageTitle() {
		st = new SoftAssert();

		w = new ChromeDriver();
		w.manage().window().maximize();
		w.get("http://blazedemo.com/");

		String pageTitle = w.getTitle();
		st.assertEquals(pageTitle, "BlazeDemo");

		st.assertAll();
	}

	@Test(priority = 1, description = "TC11-2:To validate the list and page lable")
	public void dropDownlist() {
		st = new SoftAssert();
		w.findElement(By.name("fromPort")).sendKeys("Boston");
		w.findElement(By.name("toPort")).sendKeys("London");
		w.findElement(By.cssSelector("input[type='submit']")).click();
		
		WebElement pageLabel = w.findElement(By.xpath("/html/body/div[2]/h3"));
		String label = pageLabel.getText();
		st.assertTrue(label.contains("Flights from Boston to London"), "page label is different");

		st.assertAll();
	}

	@Test(priority = 2, description = "TC11-3:To validate the page title and page label of first flight")
	public void page_Title() {
		st = new SoftAssert();

		w.findElement(By.cssSelector("input[type='submit']")).click();

		String page_Title = w.getTitle();
		st.assertEquals(page_Title, "BlazeDemo Purchase");

		WebElement page_Label = w.findElement(By.xpath("/html/body/div[2]/h2"));
		String page1 = page_Label.getText();
		st.assertTrue(page1.contains("Your flight from TLV to SFO has been reserved") , "page label is different");

		st.assertAll();
	}

	@Test(priority = 3, description = "TC11-4:To validate textbox")
	public void textField() {
		w.findElement(By.id("inputName")).clear();
		w.findElement(By.id("inputName")).sendKeys("Jones Pence");

		w.findElement(By.name("address")).clear();
		w.findElement(By.name("address")).sendKeys("Observatory Circle,U.S");

		w.findElement(By.name("city")).clear();
		w.findElement(By.name("city")).sendKeys("Phoenix");

		w.findElement(By.name("state")).clear();
		w.findElement(By.name("state")).sendKeys("Arizona(AZ)");

		w.findElement(By.name("zipCode")).clear();
		w.findElement(By.name("zipCode")).sendKeys("85001");

	}

	@Test(priority = 3, description = "TC11-5: to handle Drop Down list")
	public void drop_Downlist() throws Exception {

		WebElement Card = w.findElement(By.id("cardType"));
		Select car = new Select(Card);
		car.selectByVisibleText("American Express");

		w.findElement(By.name("creditCardNumber")).clear();
		w.findElement(By.name("creditCardNumber")).sendKeys("12345678");

		w.findElement(By.name("creditCardMonth")).clear();
		w.findElement(By.name("creditCardMonth")).sendKeys("12");

		w.findElement(By.name("creditCardYear")).clear();
		w.findElement(By.name("creditCardYear")).sendKeys("2018");

		w.findElement(By.name("nameOnCard")).clear();
		w.findElement(By.name("nameOnCard")).sendKeys("Jones Pence");

	}

	@Test(priority = 4, description = "TC11-6: to handle Checkbox")
	public void Checkbox() throws Exception {

		w.findElement(By.name("rememberMe")).click();
		Thread.sleep(2000);

		w.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
	}

	@Test(priority = 5, description = "TC11-7: To validate page Title")
	public void confirmationTitle() throws Exception {

		st = new SoftAssert();

		String confirmationTitle = w.getTitle();
		st.assertEquals(confirmationTitle, "BlazeDemo Confirmation");

		st.assertAll();
	}

	@AfterTest
	public void postCondition_TC11() {
		w.quit();
	}

}


