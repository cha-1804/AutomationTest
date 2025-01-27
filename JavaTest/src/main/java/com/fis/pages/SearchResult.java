package com.fis.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResult {

    private WebDriver driver;
    private By firstItem = By.cssSelector(".s-item a.s-item__link");

    public SearchResult(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFirstItem() {
        // Locate all items
        List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class, 's-item__wrapper clearfix')]//a[@class = \"s-item__link\"]"));
        if (items.isEmpty()) {
            throw new RuntimeException("No items found on the page.");
        }

        // Ensure at least one item is interactable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstItem = null;

        for (WebElement item : items) {
            try {
                // Wait until the item is clickable
                firstItem = wait.until(ExpectedConditions.elementToBeClickable(item));
                break;
            } catch (TimeoutException e) {
                System.out.println("Element not interactable: " + item);
            }
        }

        if (firstItem == null) {
            throw new RuntimeException("No interactable items found on the page.");
        }

        // Click the first interactable item
        firstItem.click();

        // Handle if the first item opens in a new tab
        String originalWindow = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.getWindowHandles().size() > 1);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        System.out.println("Switched to new tab or window: " + driver.getTitle());
    }


}
