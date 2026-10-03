package orangehrmpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
*/
public class LoginPage {

		WebDriver driver;
		//WebDriverWait wait;
		By username = By.xpath("//input[@name='username']");
		By password = By.xpath("//input[@name='password']");
		By loginbtn = By.xpath("//button[@type='submit']");
		
		public LoginPage(WebDriver driver) {
			this.driver=driver;	
			//this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
		//actions on the login page
		public void enterUsername(String user) {
			driver.findElement(username).sendKeys(user);
			}
		public void enterPassword(String pwd) {
			driver.findElement(password).sendKeys(pwd);
		}
		public void clickLogin() {
			driver.findElement(loginbtn).click();
		}

	}
/*public void enterUsername(String user) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
}

public void enterPassword(String pwd) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pwd);
}

public void clickLogin() {
    wait.until(ExpectedConditions.elementToBeClickable(loginbtn)).click();
}*/