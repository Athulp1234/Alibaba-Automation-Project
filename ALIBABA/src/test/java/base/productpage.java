package base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productpage {
	
	WebDriver driver;
	
	public void productBuy() {
		driver.findElement(By.xpath("//*[contains(@class,'search-bar-input util-ellipsis')]")).sendKeys("Mobiles");
		driver.findElement(By.xpath("//*[contains(@class,'fy23-icbu-search-bar-inner-button')]")).click();
	}
	


}
