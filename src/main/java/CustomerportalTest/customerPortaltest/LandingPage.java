package CustomerportalTest.customerPortaltest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractMethods;

public class LandingPage extends AbstractMethods{
	 WebDriver driver;
	 
		public LandingPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
		
		@FindBy(xpath = "//button[@type='submit']")
		//encapsulation: to hide the implementation details so that the fields cannot be used in some other class.
		private WebElement nextButton;
		
		@FindBy(id = "email")
		private WebElement email;
		
		@FindBy(id="password")
		private WebElement password;
		
		@FindBy(css="div.jss41.error")
		private WebElement confMess;
		
		
		public void goTo() {
			driver.get("https://customer-portal-testing.graebert.com");
		}
		
		public String verifyelement() {
			String valueAttribute = nextButton.getAttribute("tabindex");
			return valueAttribute;
		}
		
		public String putEmail(String username) {
			email.sendKeys(username);
			LandingPage test12 = new LandingPage(driver);
			test12.waitForElementToAppear(nextButton);
			String test3 = nextButton.getAttribute("tabindex");
			nextButton.click();
			test12.waitForElementToAppear(password);
			return test3;
		}
		
		public Boolean putPassword(String Pass) {
			password.sendKeys(Pass);
			Boolean true1 = nextButton.isEnabled();
			nextButton.click();
			return true1;
		}
		public String confirmMessage() {
			LandingPage test12 = new LandingPage(driver);
			test12.waitForElementToAppear(confMess);
			String message = confMess.getText();
			return message;
		}
		
}
