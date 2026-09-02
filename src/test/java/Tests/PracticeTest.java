package Tests;

import Pages.PracticePage;
import org.testng.annotations.Test;



public class PracticeTest extends base {

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
}
