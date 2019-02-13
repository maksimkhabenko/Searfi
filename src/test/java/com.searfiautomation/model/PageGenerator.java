package com.searfiautomation.model;

import com.searfiautomation.helper.TestConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {
    public WebDriver driver;
    public String baseUrl;

    public PageGenerator(WebDriver driver){
        this.driver = driver;
        this.baseUrl = TestConfiguration.getTestConfiguration().getBaseURL();
    }

    //JAVA Generics to Create and return a New Page
    public  <TPage extends BasePage> TPage GetInstance (Class<TPage> pageClass) {
        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
