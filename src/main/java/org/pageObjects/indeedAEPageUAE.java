package org.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class indeedAEPageUAE {

    public WebDriver driver;

    private By signInButton = By.xpath("//div[@data-gnav-element-name='SignIn']//div[@class='css-1ble2gn eu4oa1w0']//a[contains(@href,'https://secure.indeed.com/account/login?') and contains(text(),'Sign in')]");

    public indeedAEPageUAE(WebDriver driver) {
        this.driver=driver;
    }

    public void pageLoad(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    public void signIntoIndeed() {
        driver.findElement(signInButton).click();
    }

}
