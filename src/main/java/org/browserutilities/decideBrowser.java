package org.browserutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class decideBrowser {

    static WebDriver driver;

    public static WebDriver passBrowserData(String browser) {
        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("118");
            return new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setBrowserVersion("118");
            return new FirefoxDriver(options);
        } else if (browser.equals("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.setBrowserVersion("118");
            return new EdgeDriver(options);
        } else {
            return null;
        }
    }
}
