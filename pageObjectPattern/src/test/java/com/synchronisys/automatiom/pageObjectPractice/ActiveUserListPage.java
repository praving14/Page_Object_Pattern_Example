package com.synchronisys.automatiom.pageObjectPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pravin on 8/19/2015.
 */
public class ActiveUserListPage {

    public final WebDriver driver;

    By peopleLocator = By.xpath(".//*[@id='collapseListGroupHeading1']/h4/a");
    By userLocator = By.linkText("Users");
    By inactiveUserLocator = By.id("deactivatedList");
    By noUserClientLocator = By.xpath(".//*[@id='systemUserTable']/tbody/tr/td");

    public ActiveUserListPage(WebDriver driver){
        this.driver = driver;
    }
// In dashboard, Click on People option. Under people, select the Users option
    public ActiveUserListPage viewUserPage(){
        driver.findElement(peopleLocator).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(userLocator).click();
        driver.get("http://indasil.homedns.org/app/people/user/list");
        return this;

    }
// Clicking the Inactive button to see the list of Inactive users
    public ActiveUserListPage userInactive(){
        driver.findElement(inactiveUserLocator).click();
        driver.get("http://indasil.homedns.org/app/people/user/list/deactive");
        return this;
    }

// getting the text that we get when there is no Inactive users
    public String getInactiveUserText() {

        return driver.findElement(noUserClientLocator).getText();

    }

}
