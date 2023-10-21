package org.TestRunner;

import org.browserutilities.decideBrowser;
import org.testng.annotations.*;

public class TestWebSites extends decideBrowser {

    String indeedUrl = "https://ae.indeed.com";
    String baytUrl = "https://www.bayt.com/";
    String gulfTalentUrl = "https://www.gulftalent.com/";


    @BeforeMethod()
    public void openBrowser() {
        driver = decideBrowser.passBrowserData("chrome");
        assert driver != null;

    }

    @Test(priority = 1, groups = { "regressiontest", "smoketest" })
    public void indeedWebsiteTest() {
        driver.get(indeedUrl);
        System.out.println("indeedWebsite");

    }

    @Test(priority = 2, groups = { "regressiontest", "smoketest" })
    public void baytWebsiteTest(){
        driver.get(baytUrl);
        System.out.println("baytWebsite");
    }


    @Test(priority = 3, groups = { "regressiontest" })
    public void gulftalentWebsiteTest(){
        driver.get(gulfTalentUrl);
        System.out.println("gulfTalent");
    }

    @AfterMethod()
    public void closeBrowser(){
        driver.quit();
    }

}