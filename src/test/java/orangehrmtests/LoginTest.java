package orangehrmtests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import orangehrmpages.LoginPage;

public class LoginTest {

    WebDriver driver;

    // Runs before the test: opens the browser and the login page
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    // The actual test: log in, then check that it worked
    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
                "Login failed: dashboard page did not open");
    }
    // Second test: a wrong password should show an error message
    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();

        String errorText = driver.findElement(
                By.xpath("//p[contains(@class,'oxd-alert-content-text')]")).getText();

        Assert.assertEquals(errorText, "Invalid credentials");
    }

    // Runs after the test: closes the browser
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}