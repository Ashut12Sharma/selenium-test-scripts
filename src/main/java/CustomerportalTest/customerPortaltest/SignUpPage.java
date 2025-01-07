package CustomerportalTest.customerPortaltest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractMethods;

public class SignUpPage extends AbstractMethods{
	WebDriver driver;
	public SignUpPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="SIGN UP")
	WebElement SignUp;
	
	@FindBy(id = "next-button-stage1")
	WebElement nextButton;
	
	
	public String clickSignUpLink() {
		SignUp.click();
		waitForElementToAppear(nextButton);
        return nextButton.getAttribute("class");
		
	}
	  
		
}
