package ClickTime.ClickTime;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ClickTest {
    public String url = "https://login.clicktime.com/qa/";
    public String name = "firstname Lastname";
    public String email = "click@clcik.com";
    public String zip = "52422";
    public String comments = "testing the application!";
    WebDriver driver;
    String message;
    String errMessage = "Some fields were left blank. Please complete the form and try again.";
	PageObj pagelements = new PageObj(driver);

    
    @BeforeClass
    public void setup() {
    	System.setProperty("webdriver.chrome.driver","path/to/chromedriver");
    	driver = new ChromeDriver();
    }
    
    @Test
    public void testClikTime() {
    	driver.get(url);
    	Assert.assertTrue(pagelements.isNameLabelPresent());
    	pagelements.setFullName(name);
    	Assert.assertTrue(pagelements.isEmailLabelPresent());
    	pagelements.setEmail(email);
    	Assert.assertTrue(pagelements.isZipLabelPresent());
    	pagelements.setZipcode(zip);
    	Assert.assertTrue(pagelements.isCommentsLabelPresent());
    	pagelements.setComments(comments);
    	pagelements.submitForm();    	
    	Assert.assertTrue(pagelements.isSuccessMessagePresent());
    	message = pagelements.getsuccessMessage();
    	Assert.assertEquals(message, name+", your feedback has been submitted. Thanks for contacting us!");
    }
    
    @Test
    public void testEmptyForm() {
    	driver.get(url);
    	pagelements.submitForm(); 
    	Assert.assertTrue(pagelements.isErrorMessagePresent());
    	message = pagelements.getErrorMessage();
    	Assert.assertEquals(message, errMessage);
    }
    
    @AfterClass
    public void cleanup() {
    	driver.quit();
    }
}
