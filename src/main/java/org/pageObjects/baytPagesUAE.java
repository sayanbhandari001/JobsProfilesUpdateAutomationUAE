package org.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class baytPagesUAE {

    public WebDriver driver;

    private By emailAddresslocator = By.xpath("//input[@id='LoginForm_username' and @placeholder='Email Address or Username']");

    public baytPagesUAE(WebDriver driver)
    {
        this.driver=driver;
    }


    public void emailAddressInput(String userEmail){

    driver.findElement(emailAddresslocator).sendKeys(userEmail);

    }

}
