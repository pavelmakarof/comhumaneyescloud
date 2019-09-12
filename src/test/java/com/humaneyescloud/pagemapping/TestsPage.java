package com.humaneyescloud.pagemapping;

import ru.yandex.qatools.htmlelements.annotations.Name;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by makarof on 18.04.2018.
 */
public class TestsPage {
    WebDriver driver;

    public TestsPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Name("Tests Page Title")
    @FindBy(css = "[routerlink=\"\\/home\\/test\\/list\\/active\"]")
    private WebElement testsPageTitle;

    public WebElement getTestsPageTitle(){return testsPageTitle;}
}
