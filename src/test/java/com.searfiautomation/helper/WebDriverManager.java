package com.searfiautomation.helper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaOptions;


public class WebDriverManager {
    private static WebDriver webDriver;
    private static OperaOptions options;

    public WebDriverManager() {

    }

    public static WebDriver getWebDriver(WebDrivers webDriverType) {
        if (webDriver ==null) {
            String wedDriverPath = TestConfiguration.getTestConfiguration().getWedDriverPath(webDriverType);
            //  String operaPath = TestConfiguration.getTestConfiguration().getWedDriverPath("");

            switch (webDriverType) {
                case ChromeDriverForWindows:
                    System.setProperty("webdriver.chrome.driver", wedDriverPath);
                    webDriver = new ChromeDriver();
                    break;
                case FireFoxDriverForWindows:
                    System.setProperty("webdriver.gecko.driver", wedDriverPath);
                    webDriver = new FirefoxDriver();
                    break;
                default:
                    throw new NullPointerException("com.firstbrige.testing.WebDriver don't exist in " + WebDrivers.class);
            }
        }
        return webDriver;
    }
}
