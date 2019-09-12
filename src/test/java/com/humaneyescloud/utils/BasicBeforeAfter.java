package com.humaneyescloud.utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by makarof on 18.04.2018.
 */
public class BasicBeforeAfter {
    public WebDriver driver;


    @Before
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void afterClass() {
        driver.quit();
    }
}
