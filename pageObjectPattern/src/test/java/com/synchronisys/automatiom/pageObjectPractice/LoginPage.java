package com.synchronisys.automatiom.pageObjectPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

/**
 * Created by Pravin on 8/19/2015.
 */
public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameLocator = By.name("j_username");
    By passwordLocator = By.name("j_password");
    By logInButtonLocator = By.id("signIn");
    By titleLocator = By.id("companyName");

    //Method to log In
    public void enterLoginInformation(String username, String password){
        this.typeUsername(username);
        this.typePassword(password);
        this.clickLogin();
    }

// method to type in username
    public LoginPage typeUsername (String username){
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

//method to type in Password
    public LoginPage typePassword (String password){
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }
// Method to click the LogIn Button
    public LoginPage clickLogin(){
        driver.findElement(logInButtonLocator).click();
        driver.get("http://indasil.homedns.org/app/dashboard");
        return this;
    }
    //When we go to the Log In page. On the top there is a Title text. We are getting tha Title text on the LogIn Page.
    public String getLoginText(){
        return driver.findElement(titleLocator).getText();
    }
}
