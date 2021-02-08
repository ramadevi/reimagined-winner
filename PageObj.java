package ClickTime.ClickTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObj {
	
	WebDriver driver; 
	
	PageObj(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td[contains(text(),'Name:')]")
	WebElement namelabel;
	@FindBy(xpath = "//input[@id='fullName']")
	WebElement nameInput;
	
	@FindBy(xpath = "//td[contains(text(),'Email:')]")
	WebElement emaillabel;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailInput;
	
	@FindBy(xpath = "//td[contains(text(),'Zip Code:')]")
	WebElement ziplabel;
	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement zipInput;
	
	@FindBy(xpath = "//td[contains(text(),'Comments:')]")
	WebElement commentlabel;
	@FindBy(xpath = "//textarea[@id='comments']")
	WebElement commentInput;
	
	@FindBy(xpath = "//input[@id='Submit1']")
	WebElement submitButton;
	
	@FindBy(xpath = "//p[contains(text(),'your feedback has been submitted.')]")
	WebElement successMessage;
	
	@FindBy(xpath = "//body/div[@id='wrapper']/div[@id='main']/div[@id='content']/span[1]")
	WebElement errorMessage;
	
	
	public Boolean isNameLabelPresent() {
		Boolean name = namelabel.isDisplayed();
		return name;
	}
	
    public void setFullName(String s) {
    	nameInput.sendKeys(s);
	}
    
    public Boolean isEmailLabelPresent() {
    	Boolean email = namelabel.isDisplayed();
		return email;
	}
	
    public void setEmail(String s) {
    	emailInput.sendKeys(s);
	}
    
    public Boolean isZipLabelPresent() {
    	Boolean zip = namelabel.isDisplayed();
		return zip;
	}
	
    public void setZipcode(String s) {
    	zipInput.sendKeys(s);
	}
    
    public Boolean isCommentsLabelPresent() {
    	Boolean comm = namelabel.isDisplayed();
		return comm;
	}
	
    public void setComments(String s) {
    	commentInput.sendKeys(s);
	}
    
    public void submitForm() {
    	submitButton.click();
	}
    
    public Boolean isSuccessMessagePresent() {
    	Boolean success = successMessage.isDisplayed();
    	return success;
    }
    
    public String getsuccessMessage() {
    	String s = successMessage.getText();
    	return s;
    }
    
    public Boolean isErrorMessagePresent() {
    	Boolean error = errorMessage.isDisplayed();
    	return error;
    }
    
    public String getErrorMessage() {
    	String s = errorMessage.getText();
    	return s;
    }


}
