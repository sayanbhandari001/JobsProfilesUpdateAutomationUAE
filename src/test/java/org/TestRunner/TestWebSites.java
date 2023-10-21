package org.TestRunner;

import org.browserutilities.decideBrowser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWebSites extends decideBrowser {

    String indeedUrl = "https://ae.indeed.com";
    String baytUrl = "https://www.bayt.com/";
    String gulfTalentUrl = "https://www.gulftalent.com/";


    @BeforeMethod()
    public void openBrowser() {
        driver = decideBrowser.passBrowserData("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test(priority = 1, groups = {"RegressionTest", "SmokeTest"})
    public void indeedWebsiteTest() {
        driver.get(indeedUrl);
        System.out.println("indeedWebsite");

    }

    @Test(priority = 2, groups = {"RegressionTest", "SmokeTest"})
    public void baytWebsiteTest() {
        driver.get(baytUrl);
        System.out.println("baytWebsite");
    }


    @Test(priority = 3, groups = {"RegressionTest", "SmokeTest"})
    public void gulfTalentWebsiteTest() {
        driver.get(gulfTalentUrl);
        System.out.println("gulfTalent");
    }

    @AfterMethod()
    public void closeBrowser() {
        driver.quit();
    }

}