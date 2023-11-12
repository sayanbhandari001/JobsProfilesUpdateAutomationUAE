package org.browserutilities;

import AppHooks.ApplicationHooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.time.Duration;


public class decideBrowser {

    static ApplicationHooks apk = new ApplicationHooks();
    static {
        try {
            apk.getProperty();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver passBrowserData(String browser) {

        //Launching browser
        System.out.println("Browser Started is " + browser);

        if (browser.equals(apk.getProperties().getProperty("browser"))) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.setBrowserVersion("118");
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setBrowserVersion("117");
            driver = new FirefoxDriver(options);
        } else if (browser.equals("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.setBrowserVersion("117");
            driver = new EdgeDriver(options);
        } else {
            throw new RuntimeException("Please pass Browser Data in Config file " + browser);
        }

        return getDriver();
    }

    public static void browserFeaturesEnabled(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
    }

}
