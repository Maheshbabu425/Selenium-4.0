import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		// In Selenium 4.0 there is a special method to invoke new tab or window newWIndow(WindowType,Window or Tab)
		driver.get("https://rahulshettyacademy.com/angularpractice/");		// to hit URL
		driver.switchTo().newWindow(WindowType.TAB);						// to invoke new tab
		//driver.switchTo().newWindow(WindowType.WINDOW);						// to invoke new Window
		Set<String> handles = 	driver.getWindowHandles();		// getWindowHandles accepts only data sets
			Iterator<String> it =handles.iterator();			// To get window handles it accepts only iterator 
			String parentWindowId=it.next();					// parent name
			String childWindowId=it.next();						// child name
			driver.switchTo().window(childWindowId);			// to open child window
			driver.get("https://rahulshettyacademy.com/");		// ton hit another site in another tab
		String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();					// To select the web element by customized css and index
		driver.switchTo().window(parentWindowId);		// switch to parent window
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);	// enter 1st course name in text field
}
}