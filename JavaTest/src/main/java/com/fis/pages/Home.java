package com.fis.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

    private WebDriver driver;
    private By searchBox = By.id("gh-ac");
    private By searchButton = By.id("gh-search-btn");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForItem(String item) {
        driver.findElement(searchBox).sendKeys(item);
        driver.findElement(searchButton).click();
    }
}
