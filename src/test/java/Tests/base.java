package Tests;

import Pages.HomePage;
import Pages.LandingPage;
import Pages.LoginPage;
import Pages.PracticePage;
import Utils.BrowserFactory;
import Utils.ReadData;
import Utils.TakesScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class base {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static TakesScreenshots takesScreenshots;
    protected static LandingPage landingPage;
    protected static PracticePage practice;
    protected static ReadData readData;
    private static BrowserFactory browserFactory;



    @BeforeSuite
    public void setUp() {
        try {
            browserFactory  = new BrowserFactory();
            browserFactory.launchBrowser("chrome", "https://ndosisimplifiedautomation.vercel.app/");
            driver = browserFactory.getDriver();


            // Initialize all page objects
            homePage = PageFactory.initElements(driver, HomePage.class);
            loginPage = PageFactory.initElements(driver, LoginPage.class);
            landingPage = PageFactory.initElements(driver, LandingPage.class);
            practice = PageFactory.initElements(driver, PracticePage.class);
            takesScreenshots = new TakesScreenshots();
            readData = new ReadData();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}