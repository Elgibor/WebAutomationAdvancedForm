package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
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

    @FindBy(id = "storage-128GB")
    WebElement storageOption;

    @FindBy(xpath = "//*[@id=\"unit-price-label\"]")
    WebElement unitPriceLabel;

    @FindBy(id = "color")
    WebElement colorDropdown;

    @FindBy(id = "quantity")
    WebElement quantityInput;

    @FindBy(id = "address")
    WebElement addressInput;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;

    @FindBy(id = "shipping-express")
    WebElement shippingOption;

    @FindBy(id = "warranty-1yr")
    WebElement warrantyOption;

    @FindBy(id = "discount-code")
    WebElement discountCodeInput;

    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountButton;

    @FindBy(id = "purchase-device-btn")
    WebElement purchaseButton;

    @FindBy(id = "view-history-btn")
    WebElement viewHistoryButton;

   // @FindBy(id = "view-invoice-INV-")



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

        public void selectColor (String color){
            colorDropdown.sendKeys(color);
        }

        public void enterQuantity (String quantity){
            quantityInput.clear();
            quantityInput.sendKeys(quantity);
        }

        public void enterAddress (String address){
            addressInput.clear();
            addressInput.sendKeys(address);
        }

        public void clickNextButton () {
            nextButton.click();
        }

        public void selectShippingOption () {
            shippingOption.click();
        }

        public void selectWarrantyOption () {
            warrantyOption.click();
        }

        public void enterDiscountCode (String discountCode){
            discountCodeInput.clear();
            discountCodeInput.sendKeys(discountCode);
        }

        public void clickApplyDiscountButton () {
            applyDiscountButton.click();
        }

        public void clickPurchaseButton () {
            purchaseButton.click();
        }

        public void clickViewHistoryButton () {
            viewHistoryButton.click();
        }

        public void clickViewInvoiceButton (String invoiceNumber){
            WebElement viewInvoiceButton = driver.findElement(By.id("view-invoice-INV" + invoiceNumber));
            viewInvoiceButton.click();
        }


}

