package com.humaneyescloud.pagemapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by makarof on 18.04.2018.
 */
public class ExamineesPage {
    WebDriver driver;

    public ExamineesPage (WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".lh-title.mb2")
    private WebElement examineesPageTitle;

    public WebElement getExamineesPageTitle() {
        return examineesPageTitle;
    }
}
