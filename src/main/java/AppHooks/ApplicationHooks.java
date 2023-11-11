package AppHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.browserutilities.decideBrowser;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.utilities.ConfigReader;

import java.io.IOException;
import java.util.Properties;

public class ApplicationHooks {

    Properties prop;
    private decideBrowser decideBrowser;
    private WebDriver driver;
    private ConfigReader reader;

    public Properties getProperties(){
        return prop;
    }

    @Before(order = 0)
    public void getProperty() throws IOException {
        reader = new ConfigReader();
        prop = reader.init_prop();
    }


    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        decideBrowser = new decideBrowser();
        driver = decideBrowser.passBrowserData(browserName);

    }


    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenShotName = scenario.getName().replaceAll("", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenShotName);
        }
    }
}
