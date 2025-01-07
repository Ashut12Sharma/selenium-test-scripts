package TestAssignent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestCases {

    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashutosh.sharma_grae\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        
            // Open the target URL
            driver.get("https://d3pv22lioo8876.cloudfront.net/tiptop/");

            // Test Case 1: Verify disabled input element
            WebElement disabledInput = driver.findElement(By.xpath(".//input[@name='my-disabled']"));
            if (!disabledInput.isEnabled()) {
                System.out.println("Test Case 1 Passed: The input element is disabled.");
            } else {
                System.out.println("Test Case 1 Failed: The input element is not disabled.");
            }

            // Test Case 2: Verify readonly input element
            WebElement readonlyInput = driver.findElement(By.xpath("//input[@value='Readonly input']"));
            if (readonlyInput.getAttribute("readonly") != null) {
                System.out.println("Test Case 2 Passed: The input element is readonly.");
            } else {
                System.out.println("Test Case 2 Failed: The input element is not readonly.");
            }

            // Test Case 3: Verify dropdown has 8 options
            WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-select']"));
            List<WebElement> options = dropdown.findElements(By.xpath(".//option"));
            if (options.size() == 8) {
                System.out.println("Test Case 3 Passed: The dropdown has 8 options.");
            } else {
                System.out.println("Test Case 3 Failed: The dropdown does not have 8 options.");
            }

            // Test Case 4: Verify submit button is disabled when Name is empty
            WebElement nameField = driver.findElement(By.xpath("//input[@id='my-name-id']"));
            nameField.clear();  // Ensure it's empty
            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
            if (!submitButton.isEnabled()) {
                System.out.println("Test Case 4 Passed: The submit button is disabled when Name is empty.");
            } else {
                System.out.println("Test Case 4 Failed: The submit button is not disabled when Name is empty.");
            }

            // Test Case 5: Verify submit button is enabled when Name and Password are filled
            WebElement passwordField = driver.findElement(By.xpath("//input[@id='my-password-id']"));
            nameField.sendKeys("Test Name");
            passwordField.sendKeys("TestPassword123");
            if (submitButton.isEnabled()) {
                System.out.println("Test Case 5 Passed: The submit button is enabled when both fields are filled.");
            } else {
                System.out.println("Test Case 5 Failed: The submit button is not enabled when both fields are filled.");
            }

            // Test Case 6: Verify 'Received' text is shown on form submission
            submitButton.click();
            Thread.sleep(3000);  // Wait for the page to process
            WebElement receivedText = driver.findElement(By.xpath("//p[contains(text(), 'Received')]"));
            if (receivedText.isDisplayed()) {
                System.out.println("Test Case 6 Passed: 'Received' text is displayed.");
            } else {
                System.out.println("Test Case 6 Failed: 'Received' text is not displayed.");
            }

              
            // Close the browser
            driver.quit();
        }
    }

