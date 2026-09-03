package Tests;

import Pages.PracticePage;
import org.testng.annotations.Test;



public class PracticeTest extends base {

    private static final String expectedUnitPrice = "R480.00";


    @Test(dependsOnGroups = "login")
    public void clickWebAutomationAdvance() throws InterruptedException {
        practice.clickWebAutomationAdvance();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver,"practice page");
    }

    @Test(dependsOnGroups = "login")
    public void selectDeviceType() throws InterruptedException {
        practice.selectDeviceType("Phone");
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver,"practice page");
    }

    @Test(priority = 1, dependsOnGroups = "login")
    public void selectDeviceBrand() throws InterruptedException {
        practice.selectDeviceBrand("Apple");
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test(priority = 2, dependsOnGroups = "login")
    public void selectStorageOption() throws InterruptedException {
        practice.selectStorageOption();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test(priority = 3, dependsOnGroups = "login")
    public void isUnitPriceCorrect() throws InterruptedException {
        practice.isUnitPriceCorrect(expectedUnitPrice);
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test(priority = 4, dependsOnGroups = "login")
    public void selectColor() throws InterruptedException {
        practice.selectColor("Blue");
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test(priority = 5, dependsOnGroups = "login")
    public void enterQuantity() throws InterruptedException {
        practice.enterQuantity("2");
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test(priority = 6, dependsOnGroups = "login")
    public void enterAddress () throws InterruptedException {
        practice.enterAddress("123 Test Street");
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test(priority = 7, dependsOnGroups = "login")
    public void clickNextButton() throws InterruptedException {
        practice.clickNextButton();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test (priority = 8, dependsOnGroups = "login")
    public void selectShippingOption() throws InterruptedException {
        practice.selectShippingOption();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test(priority = 9, dependsOnGroups = "login")
    public void selectWarrantyOption() throws InterruptedException {
        practice.selectWarrantyOption();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test(priority = 10, dependsOnGroups = "login")
    public void enterDiscountCode() throws InterruptedException {
        practice.enterDiscountCode("SAVE10");
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test(priority = 11, dependsOnGroups = "login")
    public void clickApplyDiscountButton() throws InterruptedException {
        practice.clickApplyDiscountButton();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    @Test(priority = 12, dependsOnGroups = "login")
    public void clickPurchaseButton() throws InterruptedException {
        practice.clickPurchaseButton();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

    /*@Test(priority = 13, dependsOnGroups = "login")
    public void verifyPurchaseSuccess() throws InterruptedException {

    }*/

    @Test(priority = 13, dependsOnGroups = "login")
    public void clickViewHistoryButton() throws InterruptedException {
        practice.clickViewHistoryButton();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }

   /* @Test(priority = 14, dependsOnGroups = "login")
    public void clickViewInvoiceButton() throws InterruptedException {
        practice.clickViewInvoiceButton();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver, "practice page");
    }*/


}
