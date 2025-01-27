package com.fis.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    private WebDriver driver;
        private By cartCount = By.xpath("//span[@class = \"gh-cart__icon\"]");

        public Cart(WebDriver driver) {
            this.driver = driver;
        }

        public String getCartCount() {
            return driver.findElement(cartCount).getText();
        }
    }

