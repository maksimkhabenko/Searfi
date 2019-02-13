package com.searfiautomation.pages;


import com.searfiautomation.model.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StartPage extends BasePage {
    public By loginButton = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add Business'])[1]/following::span[1]");

    public StartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage goToLoginPage (){
        click(loginButton);
        return new LoginPage(driver);
    }

}
