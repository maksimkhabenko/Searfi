package com.searfiautomation.tests;

import com.searfiautomation.helper.TestWatcherExtension;
import com.searfiautomation.model.TestBase;
import com.searfiautomation.pages.LoginPage;
import com.searfiautomation.pages.StartPage;
import io.qameta.allure.Epic;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Epic("Test")
@ExtendWith(TestWatcherExtension.class)
public class TestLogin extends TestBase {

    @Test
    @Feature("Login")
    public void loginValidUserNameValidPassword () throws InterruptedException {
        page.GetInstance(StartPage.class).goToLoginPage().login("onur@swtestacademy.com", "11223344");
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.GetInstance(LoginPage.class).login));
        page.GetInstance(LoginPage.class).verifyLoginUserName("Maka");
    }

    @Test
    @Feature("Login")
    public void loginValidUserGoogle() throws InterruptedException {
     //   page.GetInstance(StartPage.class).goToLoginPage().loginByGoogle();
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(page.GetInstance(LoginPage.class).googleButton));
      //  page.GetInstance(LoginPage.class).verifyLoginUserName("");
    }
}
