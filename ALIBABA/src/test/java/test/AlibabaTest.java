
	
	package test;

	import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
	
	import org.testng.annotations.Test;

import base.AlibabaBase;
import base.productpage;



	

	public class AlibabaTest {

	    public static WebDriver driver;

	    @BeforeTest
	    public void setup() {
	        
	       

	        driver = new ChromeDriver();
	        driver.get("https://www.alibaba.com/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    }

	    @Test(priority=2)
	    public void RegisterTest() {
	       
	        
	    	AlibabaBase bd=new AlibabaBase(driver);
	    	bd.fillRegistrationForm();}

	   
	   
	        
	        @Test
			public void titleTest() throws IOException {
			AlibabaBase ob1=new AlibabaBase(driver);
			ob1.titleverification();

	    }
	        
	        @Test(priority=1)
	        public void product() {
	        	productpage ob2=new productpage();
	        	ob2.productBuy();
	        	
	        }
	      
	        
	
	        public void dropdown() throws IOException {
	        	
	        	AlibabaBase ob3=new AlibabaBase(driver);
	        	
	        	Actions act=new Actions(driver);
	    		act.sendKeys(Keys.PAGE_DOWN).perform();
	    		Actions act1=new Actions(driver);
	    		act1.sendKeys(Keys.PAGE_DOWN).perform();
	    		
	    		Actions act2=new Actions(driver);
	    		act2.sendKeys(Keys.PAGE_UP).perform();
	    		ob3.Screenshot();

	    		
	        }
	        
	        @AfterTest
	        public void teardown() {
	        	System.out.println("browser quit");
	        }
	}
	
