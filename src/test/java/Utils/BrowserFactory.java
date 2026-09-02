package Utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    static WebDriver driver;

    public static WebDriver launchBrowser(String browserChoice, String url) {
        if (browserChoice.equalsIgnoreCase("ChroMe")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments();
            driver = new ChromeDriver(chromeOptions);
        } else if (browserChoice.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments();
            driver = new EdgeDriver(edgeOptions);
            driver.manage().window().setSize(new Dimension(1920, 1080));
        } else {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1920,1080));
        return driver;
    }
    public WebDriver getDriver() {
        return driver;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
