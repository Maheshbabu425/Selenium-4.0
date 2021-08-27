import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementScreenShotWidthHeight {

	public static void main(String[] args) throws IOException {
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
		WebElement name=driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);	// enter 1st course name in text field
		
		
		
		// To get the name web element screen shot
		File file=name.getScreenshotAs(OutputType.FILE);		// getScreenShot method
		
		FileUtils.copyFile(file, new File("logo.png"));			// file utils method
		
		//To get Height and Width of web elements
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
	}

}
