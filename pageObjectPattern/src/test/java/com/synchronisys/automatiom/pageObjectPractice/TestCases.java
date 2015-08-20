package com.synchronisys.automatiom.pageObjectPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pravin on 8/19/2015.
 */
public class TestCases {
//Test 1
    @Test
    public void testLogintitle() throws Exception{

        WebDriver driver = new FirefoxDriver();
        LoginPage logintest =new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // waiting 10 seconds before the next step
        driver.get("http://indasil.homedns.org/app/secure");
        String logInTitle =  logintest.getLoginText();

        // Test 1 : to test the Log in title text. If the tile text is not "Indasil Solutions Inc", we get a message that says "The test 1 failed!!"
        Assert.assertEquals("Indasil Solutions Inc", logInTitle, " The test 1 failed!!");
        driver.quit();

    }

//Test 2
    @Test
    public void dashboardTextTest() throws Exception{

        WebDriver driver = new FirefoxDriver();
        LoginPage logintest =new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://indasil.homedns.org/app/secure");

        // Now I am logging in using the username and Password
        logintest.enterLoginInformation("aditya@indasil.com", "carapace23");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DashboardPage dashboardPage = new DashboardPage(driver);
        String dashboardText = dashboardPage.getDashboardText();

        // Test 2: Test to see if we are logged in and are in the dashboard page.
        // We are confirming the Dashboard title text is "Dashboard".
        // If we didnot get the Dashboard title text we get the error message "The test 2 failed!!"
        Assert.assertEquals("Dashboard", dashboardText, "The test 2 failed!!");
        driver.quit();

    }

//Test 3
    @Test
    public void inactiveUsertest() throws Exception{

        WebDriver driver = new FirefoxDriver();
        LoginPage logintest =new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://indasil.homedns.org/app/secure");

        // Now logging in using the username and Password
        logintest.enterLoginInformation("aditya@indasil.com", "carapace23");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Clicking on the People. Then, selecting the Users under People options
        ActiveUserListPage userInactivelist = new ActiveUserListPage(driver);
        userInactivelist.viewUserPage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Click Inactive to see the inactive user List
        userInactivelist.userInactive();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // When there is no inactive user , we get a text saying "No client", Lets see if we can test it
        String theTextWeGetWhenThereIsNoInactiveUser = userInactivelist.getInactiveUserText();

        //Test 3: IF there is no inactive user, we get "No Client" text, lets test if we will get that text
        // If we donot get the test "No clients". We get the error message "The Test 3 failed!!"
        Assert.assertEquals("No clients", theTextWeGetWhenThereIsNoInactiveUser, "The Test 3 failed");
        driver.quit();
    }
}
