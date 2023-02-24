import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class PracticoSelenium {

    @Test
    public void fullRegistrationTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//button[@data-cookiebanner=\"accept_button\"]")).click();

        driver.findElement(By.linkText("Create new account")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement myElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
        myElement.click();

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");

        WebElement elementoDias = driver.findElement(By.id("day"));
        Select diasSelect = new Select(elementoDias);
        diasSelect.selectByValue("26");

        WebElement elementoMeses = driver.findElement(By.id("month"));
        Select mesesSelect = new Select(elementoMeses);
        mesesSelect.selectByVisibleText("Jun");

        WebElement elementoAnio = driver.findElement(By.id("year"));
        Select anioSelect = new Select(elementoAnio);
        anioSelect.selectByValue("1980");

        List<WebElement> listaGenero = driver.findElements(By.name("sex"));

        WebElement generoHombreRadiobutton = listaGenero.get(1);
        generoHombreRadiobutton.click();
    }

}
