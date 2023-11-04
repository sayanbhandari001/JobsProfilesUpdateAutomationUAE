package org.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class indeedAEPageUAE {

    WebDriver driver;

    private By signInButton = By.xpath("(//div[@data-gnav-element-name='SignIn']//a[text()='Sign in'])[1]");
//    By ;


    public indeedAEPageUAE(WebDriver d) {
        this.driver=driver;
        driver = d;
    }

    public boolean signIntoIndeed() {
        driver.findElement(signInButton).click();
        return false;
    }

}
