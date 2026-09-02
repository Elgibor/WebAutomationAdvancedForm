package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticePage {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='Web Automation Advance']")
    WebElement webAutomationAdvance;

    @FindBy(id = "deviceType")
    WebElement deviceTypeDropdown;


    public PracticePage(WebDriver driver) {
        this.driver = driver;}


            public void clickWebAutomationAdvance () {
            webAutomationAdvance.click();
        }

        public void selectDeviceType (String deviceType){
            deviceTypeDropdown.sendKeys(deviceType);
        }
}

