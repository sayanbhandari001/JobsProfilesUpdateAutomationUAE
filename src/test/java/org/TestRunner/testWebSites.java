package org.TestRunner;

import org.browserutilities.decideBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class testWebSites {


    @Test()
    public void indeedWebsiteTest() {

        WebDriver driver = decideBrowser.passBrowserData("chrome");

    }
}
