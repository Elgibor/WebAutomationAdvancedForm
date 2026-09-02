package Tests;

import Utils.ReadData;
import org.testng.annotations.Test;

public class LoginTests extends base{


    @Test
    public void clickLoginButton() throws InterruptedException {
        takesScreenshots.takesSnapShot(driver,"landing page");
        homePage.clickLoginButton();
    }

    @Test(priority = 1)
    public void enterUsernameTests(){
        loginPage.enterUsername(ReadData.username);
    }

    @Test(priority = 2)
    public void enterPassword(){
        loginPage.enterPassword(ReadData.password);
        takesScreenshots.takesSnapShot(driver,"login page");
    }

    @Test(priority = 3)
    public void clickLoginSubmitButton() throws InterruptedException {
        loginPage.clickLoginSubmitButton();
        Thread.sleep(2000);
        takesScreenshots.takesSnapShot(driver,"dashboard page");
    }
    @Test(priority = 4)
    public void verifyLoginSuccessTest(){
        landingPage.verifyLoginSuccess();
        takesScreenshots.takesSnapShot(driver,"Landing page");
    }

    @Test(priority = 5)
    public void clickDropdownButton() throws InterruptedException {
        landingPage.clickProfileDropdown();
        takesScreenshots.takesSnapShot(driver,"landing page");
    }

    @Test(priority = 6)
    public void clickLearningMaterialsOption() throws InterruptedException {
        landingPage.clickLearningMaterialsOption();
        takesScreenshots.takesSnapShot(driver,"landing page");
    }
}
