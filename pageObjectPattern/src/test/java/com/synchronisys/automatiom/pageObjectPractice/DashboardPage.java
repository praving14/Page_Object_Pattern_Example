package com.synchronisys.automatiom.pageObjectPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Pravin on 8/19/2015.
 */
public class DashboardPage {

    public final WebDriver driver;

    By dashboardTextLocator = By.xpath("html/body/div[4]/h2");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

// We we get to the dashboard page after log In, we get a Dashboard titlte that says "Dashboard". Let's get that title/
    public String getDashboardText(){
        return driver.findElement(dashboardTextLocator).getText();
    }



}
