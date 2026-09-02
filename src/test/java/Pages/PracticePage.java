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

    @FindBy(id = "brand")
    WebElement brandDropdown;

    @FindBy(xpath = "//span[text()='128GB']")
    WebElement storageOption;

    @FindBy(xpath = "//*[@id=\"unit-price-label\"]")
    WebElement unitPriceLabel;

    public PracticePage(WebDriver driver) {
        this.driver = driver;}


            public void clickWebAutomationAdvance () {
            webAutomationAdvance.click();
        }

        public void selectDeviceType (String deviceType){
            deviceTypeDropdown.sendKeys(deviceType);
        }

        public void selectDeviceBrand (String brand){
            brandDropdown.sendKeys(brand);
        }

        public void selectStorageOption () {
            storageOption.click();
        }

        public String getUnitPriceText () {
            return unitPriceLabel.getText();
        }

        public boolean isUnitPriceCorrect (String expectedUnitPrice){
            String actualPrice = getUnitPriceText();
            return actualPrice.equals(expectedUnitPrice);
        }

        public double getUnitPriceAsDouble () {
            String priceText = getUnitPriceText();
            // Remove any currency symbols and commas, then parse to double
            String numericPrice = priceText.replaceAll("[^\\d.]", "");
            return Double.parseDouble(numericPrice);
        }

        /*public void verifyUnitPrice (String expectedUnitPrice){
            if (!isUnitPriceCorrect(expectedUnitPrice)) {
                throw new AssertionError("Expected price: " + expectedUnitPrice + ", but got: " + getUnitPriceText());
            }
        }*/
}

