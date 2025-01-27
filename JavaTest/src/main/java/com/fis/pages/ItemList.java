package com.fis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ItemList {
    private WebDriver driver;
    private By addToCartButton = By.xpath("//a[contains(@id, 'atcBtn_btn')]");

    public ItemList(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
}

