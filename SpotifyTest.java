package Clase15.Test;

import Clase15.Page.LandingPage;
import Clase15.Page.PremiumPage;
import Clase15.Page.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpotifyTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/");
    }

    @Test
    public void checkTitleUrl() {
        LandingPage landingPage = new LandingPage(driver);

        Assert.assertEquals(landingPage.getPageTitle(), "Spotify - Web Player: Music for everyone", "El título no es correcto");
        Assert.assertEquals(landingPage.getPageUrl(), "https://open.spotify.com/?", "La URL no es correcta");
    }

    @Test
    public void registrationErrorMessage() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        landingPage.setWait();
        landingPage.clickSignUpBtn();

        landingPage.setWait();
        registrationPage.errorMessageEmail();

    }

    @Test
    public void assertH1PremiumPage() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        PremiumPage premiumPage = new PremiumPage(driver);

        landingPage.setWait();
        landingPage.clickPremiumBtn();

        premiumPage.checkH1();
    }

}
