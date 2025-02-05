	
	package base;

	import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


	public class AlibabaBase {
		
		WebDriver driver;

		
		@FindBy(xpath = "//*[contains(@class,'tnh-button tnh-sign-up')]")
		WebElement bdSbutton;
		@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[3]/div/label[1]/span[1]/input")
		WebElement toggle;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[4]/input")
		WebElement bdEmail;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[5]/input")
		WebElement bdPassword;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[6]/input")
		WebElement bdConfirmPassword;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[7]/input")
		WebElement bdCompanyName;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[8]/input[1]")
		WebElement bdFirstName;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[8]/input[2]")
		WebElement bdLastName;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[9]/input[3]")
		WebElement bdPhoneNumber;
		
		@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[11]/div/div/span[1]/input")
		WebElement bdCheckBox;
		
		@FindBy(xpath= "//*[@id=\"root\"]/div/div[2]/button/span")
		WebElement bdCreateAccount;
		
		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/button")
		WebElement bdLoginButton;

		
		public AlibabaBase(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void fillRegistrationForm() {
			// TODO Auto-generated method stub
			bdSbutton.click();
			toggle.click();
			bdEmail.sendKeys("athulprahlas05@gmail.com");
			bdPassword.sendKeys("Athulp@1234");
			bdConfirmPassword.sendKeys("Athulp@1234");
			bdCompanyName.sendKeys("Luminar TechnoLab");
			bdFirstName.sendKeys("Athul");
			bdLastName.sendKeys("Prahalad"); 
			bdPhoneNumber.sendKeys("8590622683");
			bdCheckBox.click();
			bdCreateAccount.click();
			
		}
		public void submitForm() {
			bdLoginButton.click();
		}
		
		
		
		public void countLink() {
			  List<WebElement>Links=driver.findElements(By.tagName("a"));
			  System.out.println("number of links="+Links.size());
		}
		
		
		public void titleverification() throws IOException {
			String title=driver.getTitle()	;
			 System.out.println(title);	
			 
			 String actualTitle=driver.getTitle();
				String expectedTitle="JpetStore";
				Assert.assertEquals(expectedTitle, actualTitle);
			 
			 String pagesource=driver.getPageSource();
			 if(pagesource.contains("computers")) {
				 System.out.println("pagesource computers present");}
				 else {
					 System.out.println("pagesource computers absent");


	}
			 
			 List<WebElement>linkcounts=driver.findElements(By.tagName("a"));
				System.out.println("Total number of links="+linkcounts.size());
				
	 
			List<WebElement>link=driver.findElements(By.tagName("a"));
			for(WebElement e1:link) {
				String links =e1.getAttribute("href");
				System.out.println("Link:"+link);
				
				try { 
					URL u=new URL(links);
					HttpURLConnection coc=(HttpURLConnection)u.openConnection();
					int code =coc.getResponseCode();
					
					if(code==200) {
						System.out.println("200------"+links);
					}
					else if(code==404) {
						System.out.println(" 404-------"+links);
					}
					else {
						System.out.println("other code------"+links);
					}
					
					
				} catch (MalformedURLException e) {
				
				}
				WebElement logo=driver.findElement(By.xpath("//*[@id=\"the-new-header\"]/div[1]/div[2]/div[1]/div"));
				boolean l=logo.isDisplayed();
				if(l) {
					System.out.println("Logo is present");
				}
				else {
					System.out.println("Logo is absent");
				}

			}
		}
			
			public void Screenshot() throws IOException {
			
				File s=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(s, new File(".\\Screenshot\\img1.png"));

		}
		
			
			
		
		}