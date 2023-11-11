package org.TestRunner;

import AppHooks.ApplicationHooks;
import org.testng.annotations.Test;
import org.browserutilities.decideBrowser;
import org.pageObjects.baytPagesUAE;
import org.pageObjects.indeedAEPageUAE;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestWebSites extends decideBrowser {

    static ApplicationHooks apk = new ApplicationHooks();
    static {
        try {
            apk.getProperty();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    String indeedUrl = "https://ae.indeed.com";
    String baytUrl = "https://www.bayt.com/en/login/";
    String gulfTalentUrl = "https://www.gulftalent.com/";

    public indeedAEPageUAE indeedUAE = new indeedAEPageUAE(decideBrowser.getDriver());
    public baytPagesUAE baytUAE = new baytPagesUAE(decideBrowser.getDriver());

    @BeforeMethod()
    public void openBrowser() {
        decideBrowser.passBrowserData(apk.getProperties().getProperty("browser"));
        assert driver != null;
        decideBrowser.browserFeaturesEnabled();
    }

    @Test(priority = 1, groups = {"RegressionTest", "SmokeTest"})
    public void indeedWebsiteTest() {
        System.out.println("Executing Indeed UAE Profile update of User");
        driver.get(indeedUrl);
        System.out.println("Indeed Website url used is " + indeedUrl);
        indeedUAE.signIntoIndeed();
        //System.out.println(indeedUAE.signIntoIndeed());
    }

//    @Test(priority = 2, groups = {"RegressionTest", "SmokeTest"})
    public void baytWebsiteTest() {
        System.out.println("Executing Bayt UAE Profile update of User");
        driver.get(baytUrl);
        System.out.println("Bayt Website url used is " + baytUrl);
        baytUAE.emailAddressInput("sayanbhandari007@gmail.com");
    }

//    @Test(priority = 3, groups = {"RegressionTest", "SmokeTest"})
    public void gulfTalentWebsiteTest() {
        System.out.println("Executing GulfTalent UAE Profile update of User");
        driver.get(gulfTalentUrl);
        System.out.println("GulfTalent Website url used is " + gulfTalentUrl);
    }

    @AfterMethod()
    public void closeBrowser() {
        driver.quit();
    }

}