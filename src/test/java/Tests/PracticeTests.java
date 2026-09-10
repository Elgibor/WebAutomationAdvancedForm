package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PracticeTests extends base {

    private static final String expectedUnitPrice = "R480.00";
    private static final double expectedSubtotal = 960.00;
    private static final double expectedQuantity = 2;


    @Test(dependsOnGroups = "login")
    public void clickWebAutomationAdvance() throws InterruptedException {
        practice.clickWebAutomationAdvance();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test(priority = 1, dependsOnGroups = "login")
    public void verifyInventoryFormDisplayed() throws InterruptedException {
        practice.verifyInventoryFormDisplayed();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test(priority = 2, dependsOnGroups = "login")
    public void selectDeviceType() throws InterruptedException {
        practice.selectDeviceType("Phone");
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 3, dependsOnGroups = "login")
    public void verifyBrandDropdownIsEnabled() throws InterruptedException {
        practice.verifyBrandDropdownIsEnabled();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 4, dependsOnGroups = "login")
    public void selectDeviceBrand() throws InterruptedException {
        practice.selectDeviceBrand("Apple");
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 5, dependsOnGroups = "login")
    public void verifyDevicePreviewIsDisplayed() throws InterruptedException {
        practice.verifyDevicePreviewIsDisplayed();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 6, dependsOnGroups = "login")
    public void selectStorageOption() throws InterruptedException {
        practice.selectStorageOption();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }


    @Test(priority = 7, dependsOnGroups = "login")
    public void verifyUnitPrice() throws InterruptedException {
        boolean isPriceCorrect = practice.unitPriceR400IsDisplayed(expectedUnitPrice);
        Assert.assertTrue(isPriceCorrect, "Unit price is not displayed correctly.");
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }


    @Test(priority = 8, dependsOnGroups = "login")
    public void selectColor() throws InterruptedException {
        practice.selectColor("Blue");
        Thread.sleep(2000);

        //Verify Blue is selected
        assert practice.isColorSelected("Blue") : "Blue color is not selected!";

        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 9, dependsOnGroups = "login")
    public void enterQuantity() throws InterruptedException {
        practice.enterQuantity("2");
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 10, dependsOnGroups = "login")
    public void verifySubtotal() throws InterruptedException {
        practice.verifySubtotal(expectedSubtotal);
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 11, dependsOnGroups = "login")
    public void enterAddress() throws InterruptedException {
        String address =  practice.enterAddress("123 Test Street");
        Assert.assertEquals(address, "123 Test Street", "Address does not match the expected value.");
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 14, dependsOnGroups = "login")
    public void clickNextButton() throws InterruptedException {
        practice.clickNextButton();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 15, dependsOnGroups = "login")
    public void verifyOrderPreviewIsDisplayed() throws InterruptedException {
        practice.verifyOrderPreviewIsDisplayed();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }


    @Test(priority = 16, dependsOnGroups = "login")
    public void selectShippingOption() throws InterruptedException {
        practice.selectExpressShippingOption();

        boolean isShippingApplied = practice.isExpressShippingApplied("R25.00");
        Assert.assertTrue(isShippingApplied, "Express shipping is not applied correctly.");

        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 17, dependsOnGroups = "login")
    public void selectWarrantyOption() throws InterruptedException {
        practice.selectWarrantyOption();

        boolean isWarrantyApplied = practice.isWarrantyApplied("R49.00");
        Assert.assertTrue(isWarrantyApplied, "Warranty is not applied correctly.");

        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 18, dependsOnGroups = "login")
    public void enterDiscountCode() throws InterruptedException {
        practice.enterDiscountCode("SAVE10");
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 19, dependsOnGroups = "login")
    public void clickApplyDiscountButton() throws InterruptedException {
        practice.clickApplyDiscountButton();

        boolean isDiscountApplied = practice.isDiscountApplied();
        Assert.assertTrue(isDiscountApplied, "Discount is not applied correctly.");

        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "inventory form");
    }

    @Test(priority = 20, dependsOnGroups = "login")
    public void clickConfirmPurchaseButton() throws InterruptedException {
        practice.clickConfirmPurchaseButton();
        Thread.sleep(3000);
        takesScreenshots.takesSnapShot(driver, "purchase confirmation");
    }


    @Test(priority = 21, dependsOnGroups = "login")
    public void clickViewInvoiceOnSuccessPage() throws InterruptedException {
        practice.clickViewInvoiceOnSuccessPage();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "invoice history panel");
    }


    @Test(priority = 22, dependsOnGroups = "login")
    public void clickViewButtonInHistory() throws InterruptedException {
        // Click the View button in the history panel
        practice.clickViewButtonInHistory();
        Thread.sleep(3000);

        takesScreenshots.takesSnapShot(driver, "invoice details opened");
    }

}
