import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		
		// Finding the name label with name text field	...above() method
		WebElement name =driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(withTagName("label").above(name)).getText());
		
		// Enter the date of birth by using date of birth label...below() method
	 WebElement dob	=driver.findElement(By.cssSelector("[for='dateofBirth']"));
	 driver.findElement(withTagName("input").below(dob)).sendKeys("1993/08/26");
	 
	 // Select the ice cream check box with ice cream label..toLeftOf()  method
	 WebElement iceCb =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
	 driver.findElement(withTagName("input").toLeftOf(iceCb)).click();
	 
	 // Select the student label and print the student...toRightOf() method
	WebElement studentRb= driver.findElement(By.id("inlineRadio1"));
	System.out.println(driver.findElement(withTagName("label").toRightOf(studentRb)).getText());
	 

	}

}
	