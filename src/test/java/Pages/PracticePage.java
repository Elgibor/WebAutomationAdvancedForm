package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PracticePage {

    WebDriver driver;


    @FindBy(xpath = "//span[text()='Web Automation Advance']")
    WebElement webAutomationAdvance;

    @FindBy(id = "inventory-form")
    WebElement inventoryForm;

    @FindBy(id = "deviceType")
    WebElement deviceTypeDropdown;

    @FindBy(id = "brand")
    WebElement brandDropdown;

    @FindBy(id = "device-preview")
    WebElement devicePreview;

    @FindBy(id = "storage-128GB")
    WebElement storageOption;

    @FindBy(id = "unit-price-value")
    WebElement unitPriceLabel;

    @FindBy(id = "color")
    WebElement colorDropdown;

    @FindBy(id = "quantity")
    WebElement quantityInput;

    @FindBy(id = "subtotal-value")
    WebElement subtotalValue;

    @FindBy(id = "address")
    WebElement addressInput;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;

    @FindBy(id = "device-summary")
    WebElement orderPreview;

    @FindBy(id = "shipping-option-express")
    WebElement shippingOption;

    @FindBy(id = "breakdown-shipping-value")
    WebElement shippingCostValue;

    @FindBy(id = "warranty-1yr")
    WebElement warrantyOption;

    @FindBy(id = "breakdown-warranty-value")
    WebElement warrantyCostValue;

    @FindBy(id = "discount-code")
    WebElement discountCodeInput;

    @FindBy(id = "discount-feedback")
    WebElement discountValue;

    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountButton;

    @FindBy(id = "purchase-device-btn")
    WebElement purchaseButton;

    @FindBy(id = "view-history-btn")
    WebElement viewInvoiceOnSuccessPage;

    @FindBy(xpath = "//button[contains(text(), 'View')]")
    WebElement viewButtonInHistory;


    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickWebAutomationAdvance() {
        webAutomationAdvance.click();
    }

    public void verifyInventoryFormDisplayed() {
        if (!inventoryForm.isDisplayed()) {
            throw new AssertionError("Inventory form is not displayed");
        }
    }

    public void selectDeviceType(String deviceType) {
        Select deviceTypeSelect = new Select(deviceTypeDropdown);
        deviceTypeSelect.selectByVisibleText(deviceType);
    }

    public void verifyBrandDropdownIsEnabled() {
        if (!brandDropdown.isEnabled()) {
            throw new AssertionError("Brand dropdown is not enabled");
        }
    }

    public void selectDeviceBrand(String brand) {
        brandDropdown.sendKeys(brand);
    }

    public void verifyDevicePreviewIsDisplayed() {
        if (!devicePreview.isDisplayed()) {
            throw new AssertionError("Device preview is not displayed");
        }
    }

    public void selectStorageOption() {
        storageOption.click();
    }

    //---STEP 7: Unit Price ---
    public String getUnitPriceText() {
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(unitPriceLabel));
        return unitPriceLabel.getText();
    }

    public boolean unitPriceR400IsDisplayed(String expectedUnitPrice) {
        String actualPrice = getUnitPriceText();
        return actualPrice.equals(expectedUnitPrice);
    }

    public double getUnitPriceAsDouble() {
        // Wait for the unit price label to be visible before trying to read it
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(unitPriceLabel));

        String priceText = unitPriceLabel.getText();

        // Remove any currency symbols (like 'R') and commas, then parse to double
        String numericPrice = priceText.replaceAll("[^\\d.]", "");

        return Double.parseDouble(numericPrice);
    }

    public void selectColor(String color) {
        colorDropdown.sendKeys(color);
        Select colorSelect = new Select(colorDropdown);
        colorSelect.selectByVisibleText(color);

        // Verify selection
        WebElement selectedOption = colorSelect.getFirstSelectedOption();
        String selectedColor = selectedOption.getText();

        if (!selectedColor.equals(color)) {
            throw new AssertionError("Failed to select color: " + color + ". Got: " + selectedColor);
        }

    }

    public String getSelectedColor() {
        Select colorSelect = new Select(colorDropdown);
        WebElement selectedOption = colorSelect.getFirstSelectedOption();
        return selectedOption.getText();
    }

    public boolean isColorSelected(String expectedColor) {
        return getSelectedColor().equals(expectedColor);
    }

    public void enterQuantity(String quantity) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(quantityInput));
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(quantityInput));

        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    //STEP 8: Verify Subtotal---
    public boolean verifySubtotal(double expectedSubtotal) {
        try {
            //Get the unit price
            double unitPrice = getUnitPriceAsDouble();

            //Get the quantity
            String qtyValue = quantityInput.getAttribute("value");
            if (qtyValue == null || qtyValue.isEmpty()) {
                throw new AssertionError("Quantity input is empty.");
            }
            int quantity = Integer.parseInt(qtyValue);

            //Calculate expected subtotal
            double calculatedSubtotal = unitPrice * quantity;

            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.textToBePresentInElement(subtotalValue, String.format("%.2f", calculatedSubtotal)));
            String actualSubtotalText = subtotalValue.getText();
            String numericSubtotal = actualSubtotalText.replaceAll("[^\\d.]", "");
            double actualSubtotal = Double.parseDouble(numericSubtotal);
        } catch (Exception e) {
            System.out.println("Error verifying subtotal: " + e.getMessage());

        }
        return false;
    }


    public String enterAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);

        return addressInput.getAttribute("value");
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void verifyOrderPreviewIsDisplayed() {

        if (!orderPreview.isDisplayed()) {
            throw new AssertionError("Order preview is not displayed");
        }
    }

    //--STEP 10: Express Shipping Option---
    public void selectExpressShippingOption() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(shippingOption)).click();

    }

    public boolean isExpressShippingApplied(String expectedCost) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(shippingCostValue));
            return shippingCostValue.getText().contains(expectedCost);
        } catch (Exception e) {
            return false;
        }
    }

    //STEP 11: 1yr Warranty Option---
    public void selectWarrantyOption() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(warrantyOption)).click();
    }

    public boolean isWarrantyApplied(String expectedCost) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(warrantyCostValue));
            return warrantyCostValue.getText().contains(expectedCost);
        } catch (Exception e) {
            return false;
        }
    }

    //--STEP 12: Discount Code---
    public void enterDiscountCode(String discountCode) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(discountCodeInput)).clear();
        discountCodeInput.sendKeys(discountCode);
    }


    public void clickApplyDiscountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(applyDiscountButton)).click();
    }

    public boolean isDiscountApplied() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(discountValue));
            String discountText = discountValue.getText();
            return discountText.contains("-") || discountText.contains("%") || discountText.isEmpty();
        } catch (Exception e) {
            return false;
        }

    }

    public void clickConfirmPurchaseButton() {
        purchaseButton.click();
    }

    public void clickViewInvoiceOnSuccessPage() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(viewInvoiceOnSuccessPage)).click();
    }

    public void clickViewButtonInHistory() {
        // Wait for history panel to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewButtonInHistory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'View')]")));
        viewButtonInHistory.click();

    }


}

