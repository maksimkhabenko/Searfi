package com.searfiautomation.model;

import com.searfiautomation.helper.TestConfiguration;
import com.searfiautomation.helper.TestWatcherExtension;
import com.searfiautomation.helper.WebDriverManager;
import com.searfiautomation.helper.WebDrivers;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(TestWatcherExtension.class)
public class TestBase {
    public WebDriver driver;
    public String baseUrl;
    public WebDriverWait wait;
    public PageGenerator page;



    @BeforeAll
    public void setUp() {
        driver = WebDriverManager.getWebDriver(WebDrivers.ChromeDriverForWindows);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,15);
        page = new PageGenerator(driver);
        this.baseUrl = TestConfiguration.getTestConfiguration().getBaseURL();
        driver.manage().window().maximize();
    }


    @BeforeEach
    void BeforEachTest() {
        driver.get(baseUrl);
        System.out.println("Start Page");
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }


    @Attachment(value = "{testName} - screenshot", type = "image/png")
    public byte[] makeScreenshotOnFailure(String testName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /*
    @Attachment(value = "{elemetnt} - screenshot", type = "image/png")
    public byte[] makeScreenshotOnFailureElement(By element) {

        return ((TakesScreenshot) driver.findElement(element)).getScreenshotAs(OutputType.BYTES);
    }
    */

    /*
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        boolean testResult = extensionContext.getExecutionException().isPresent();
        System.out.println("IS FAILED: "+testResult); //false - SUCCESS, true - FAILED
        if (testResult)makeScreenshotOnFailure("ScreenshotOnFailure");
    }
    */
}
