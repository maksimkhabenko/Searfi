package com.searfiautomation.helper;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestWatcherExtension implements AfterTestExecutionCallback {
    WebDriver driver = WebDriverManager.getWebDriver(WebDrivers.ChromeDriverForWindows);

    @Attachment("ScreenshotOnFailure")
    public byte[] makeScreenshotOnFailure() { return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        boolean testResult = extensionContext.getExecutionException().isPresent();
        System.out.println(testResult); //false - SUCCESS, true - FAILED
        if (testResult) makeScreenshotOnFailure();
    }
}
