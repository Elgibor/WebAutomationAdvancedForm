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
}
