package com.searfiautomation.pages;

import com.searfiautomation.model.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public By login = By.name("email");
    public By password = By.name("password");
    public By submitButton = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log In to your Account'])[1]/following::button[1]");
    public By googleButton = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='or'])[1]/following::i[2]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass){
        writeText(login,user);
        writeText(password,pass);
        click(submitButton);
    }

    public void verifyLoginUserName (String user){
        Assert.assertEquals(readText(login),user);
    }


    public void loginByGoogle(){
        click(googleButton);
    }
}
