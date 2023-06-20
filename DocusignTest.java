package Clase15.Test;

import Clase15.Page.LandingPage;
import Clase15.Page.TrialPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocusignTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.docusign.com/");
    }

    @Test
    public void mostrarInfo() {
        LandingPage landingPage = new LandingPage(driver);

        System.out.println("La página es " + landingPage.getPageTitle());
        System.out.println("Su URL es " + landingPage.getPageUrl());

    }

    @Test
    public void freeTrialAccess() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        TrialPage trialPage = new TrialPage(driver);

        landingPage.setWait();
        landingPage.clickCookiesBanner();
        landingPage.clickFreeTrialBtn();

        landingPage.setWait();
        trialPage.completeFormTest1();
        landingPage.setWait();
        trialPage.completeFormTest2();
    }






}
