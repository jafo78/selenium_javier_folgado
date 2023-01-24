import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class TestSelenium {

    @Test
    public void googleTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.es");
        driver.findElement(By.xpath("//div[text()='Reject all']")).click();

        WebElement title = driver.findElement(By.tagName("title"));
        // Por alguna razón no me funciona .getText así que he utilizado getAttribute
        // https://stackoverflow.com/questions/40088173/selenium-java-api-why-driver-findelementby-tagnametitle-gettext-always-r
        System.out.println("Title --> " + title.getAttribute("textContent"));
        driver.close();
    }

    @Test
    public void bbcMundoTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");
        driver.findElement(By.xpath("//p[text()='Do not consent']")).click();

        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
        for (WebElement elementoH1 : listaH1s){
            System.out.println("El total de h1s es --> " + listaH1s.size());
            System.out.println("h1 --> " + elementoH1.getText());

        }

        List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));
        for (WebElement elementoH2 : listaH2s){
            System.out.println("El total de h2s es --> " + listaH2s.size());
            System.out.println("h2 --> " + elementoH2.getText());
        }
        driver.close();
    }

    @Test
    public void bbcMundoLinks() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");
        driver.findElement(By.xpath("//p[text()='Do not consent']")).click();

        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        for (WebElement elementoLink : listaLinks){
            System.out.println("Link --> " + elementoLink.getText());
        }
        driver.close();
    }

    @Test
    public void bbcMundoListas() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");
        driver.findElement(By.xpath("//p[text()='Do not consent']")).click();

        List<WebElement> listaLists = driver.findElements(By.tagName("li"));
        for (WebElement elementoList : listaLists){
            System.out.println("Elemento lista --> " + elementoList.getText());
        }
        driver.close();
    }

    @Test
    public void spotifyTitleTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/es/premium/");

        String actualTitle = driver.findElement(By.tagName("title")).getAttribute("textContent");
        String expectedTitle = "Escuchar es todo – Spotify";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        driver.close();
    }

    @Test
    public void getWindowsSizeTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.es");
        Dimension screenSize = driver.manage().window().getSize();
        System.out.println("Las dimensiones originales de la pantalla son --> " + screenSize);
        driver.manage().window().setSize(new Dimension(1024,768));
    }

    @Test
    public WebDriver getGoogleDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.es");
        return driver;
    }

    @Test
    public WebDriver getDriver(String URL) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    @Test
    public void searchInGoogle() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.es");
        driver.findElement(By.xpath("//div[text()='Reject all']")).click();
        driver.findElement(By.name("q")).sendKeys("WebElement");
        driver.findElement(By.name("btnK")).submit();
        driver.close();
    }

    @Test
    public void searchInGoogleAndGoBack() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.es");
        String title = driver.findElement(By.tagName("title")).getAttribute("textContent");
        System.out.println("El título es --> " + title);
        driver.findElement(By.xpath("//div[text()='Reject all']")).click();
        driver.findElement(By.name("q")).sendKeys("WebElement");
        driver.findElement(By.name("btnK")).submit();
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }

    @Test
    public void facebookPageTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.tagName("button")).submit();

        List<WebElement> cantidadDivs = driver.findElements(By.tagName("div"));
        for (WebElement elementoDiv : cantidadDivs) {
        }
        System.out.println("El número de 'divs' es --> " + cantidadDivs.size());

        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        for (WebElement elementoLink : listaLinks) {
            System.out.println("Link --> " + elementoLink.getText());
        }

        List<WebElement> cantidadBotones = driver.findElements(By.tagName("button"));
        for (WebElement elementoBotones : cantidadBotones) {
            System.out.println("Botón --> " + elementoBotones.getText());
        }
        System.out.println("El número de botones es --> " + cantidadBotones.size());
    }

        @Test
        public void sendKeysToFacebook() {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.facebook.com/");
            driver.findElement(By.tagName("button")).submit();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            driver.findElement(By.id("email")).sendKeys("test@test.com");
            driver.findElement(By.id("pass")).sendKeys("holamundo");
            driver.findElement(By.id("loginbutton")).submit();
    }
}



//    JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, 1800)");
//                js.executeScript("window.scrollTo(0, 0)");