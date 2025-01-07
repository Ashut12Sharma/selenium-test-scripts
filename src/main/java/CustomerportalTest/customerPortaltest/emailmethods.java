package CustomerportalTest.customerPortaltest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class emailmethods {
	

	public WebDriver driver;
	public LandingPage landingpage;
	public SignUpPage signUpPage;
	//method to control browser
	public WebDriver inititalizeBrowser() throws IOException{
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\ashutosh.sharma_grae\\eclipse-workspace\\customerPortaltest\\src\\main\\java\\customerPortal\\resources\\Global.properties");
	prop.load(fis);
	//to get command from maven
	String browserName = System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
	//String browserName = prop.getProperty("browser");
	//invoke browser
	if(browserName.contains("chrome")) {
		//create chromeoptions for headless mode
		ChromeOptions option = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless")) {
		option.addArguments("headless");
		}
		driver  = new ChromeDriver(option);
		//to open browser in maximize ot full mode
		driver.manage().window().setSize(new Dimension(1440, 990));
	}
	else if(browserName.equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	return driver;

	}
		 
		public List<HashMap<String, String>> getJsonDataToHashMap(String filePath) throws IOException {
			//method to read the jsonfile and convert into string
			String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
			//external utility jackson databind to convert string into hashmap
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
			return data;
		}
		
		public String getScrrenShot(String testCaseName , WebDriver driver) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		}
		
		
	@BeforeTest(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver= inititalizeBrowser();
		landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}





}
