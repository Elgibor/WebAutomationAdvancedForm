package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

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

    @FindBy(xpath = "//button[contains(text(), 'View Invoice')]")
    WebElement viewInvoiceOnSuccessPage;

    @FindBy(xpath = "//*[contains(text(), 'Order Successful')]")
    WebElement orderSuccessMessage;

    @FindBy(xpath = "//button[contains(text(), 'View')]")
    WebElement viewButtonInHistory;



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

        public void clickViewInvoiceOnSuccessPage () {
            viewInvoiceOnSuccessPage.click();
        }

    // Method to verify order success
    public boolean isOrderSuccessful() {
        try {
            return orderSuccessMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to get order details from success page (optional verification)
    public String getOrderDetails() {
        try {
            WebElement orderDetails = driver.findElement(By.xpath("//*[contains(text(), 'Order Details:')]/following-sibling::*"));
            return orderDetails.getText();
        } catch (Exception e) {
            return "Order details not found";
        }
    }

    // Method to check if invoice is displayed
    public boolean isInvoiceDisplayed() {
        try {
            // Look for invoice-related content
            WebElement invoiceContent = driver.findElement(By.xpath("//*[contains(text(), 'Invoice') or contains(text(), 'INV-')]"));
            return invoiceContent.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    // Method to click View button in history
    public void clickViewButtonInHistory() {
        // Wait for history panel to load
        try {
            Thread.sleep(2000);
            // Click the first View button found in the history
            viewButtonInHistory.click();
            System.out.println("Clicked View button in history");
        } catch (Exception e) {
            // If button not found by text, try by other methods
            try {
                WebElement viewBtn = driver.findElement(By.xpath("//*[contains(@id, 'view') or contains(@class, 'view')]//button"));
                viewBtn.click();
            } catch (Exception e2) {
                // Try to find any button that says View
                WebElement viewBtn = driver.findElement(By.xpath("//button[contains(., 'View')]"));
                viewBtn.click();
            }
        }
    }
    // Method to verify invoice opened
    public boolean isInvoiceOpened() {
        try {
            // Check if invoice details are displayed
            WebElement invoiceContent = driver.findElement(By.xpath("//*[contains(text(), 'Invoice') or contains(text(), 'Order Details')]"));
            return invoiceContent.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

