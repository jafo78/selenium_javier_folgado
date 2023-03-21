import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class TestNGSalesforce {

    WebDriver driver;

    @BeforeMethod
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");

    }

    @Test (priority = 0)
    public void validateSalesforceLogoTest () {
        WebElement logo = driver.findElement(By.id("logo"));
        logo.isDisplayed();
    }

    @Test (priority = 3)
    public void loginFailureTest () throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("test@test.com");
        driver.findElement(By.id("password")).sendKeys("123466");
        driver.findElement(By.id("Login")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertEquals(errorMessage.getText(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");

    }

    @Test (enabled = false)
    public void rememberMeIsSelected () {
        WebElement checkbox = driver.findElement(By.id("rememberUn"));
        checkbox.click();

        if (checkbox.isSelected()) {
            System.out.println("El checkbox está seleccionado");
        } else {
            System.out.println("El checkbox no está seleccionado");
        }
    }

    @Test (priority = 2)
    public void footerIsValid () {
        WebElement footer = driver.findElement(By.id("footer"));
        String footerText = footer.getText();

        if (footerText.contains("All rights reserved")) {
            System.out.println("'All rights reserved' se muestra en el footer");
        } else {
            System.out.println("'All rights reserved' no se muestra en el footer");
        }
    }

    @AfterMethod
    public void afterMethod () {
        // driver.close();
    }
}
