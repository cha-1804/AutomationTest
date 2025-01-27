package com.fis;

import com.fis.base.Base;
import com.fis.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddToCartTest extends Base {

        @Test
        public void verifyItemCanBeAddedToCart() {
            // Navigate to eBay homepage
            driver.get("https://www.ebay.com");

            // Page objects
            Home homePage = new Home(driver);
            SearchResult searchResultsPage = new SearchResult(driver);
            ItemList itemPage = new ItemList(driver);
            Cart cartPage = new Cart(driver);

            // Test steps
            homePage.searchForItem("book");
            searchResultsPage.clickFirstItem();
            itemPage.addToCart();

            // Assertion
            String cartCount = cartPage.getCartCount();
            Assert.assertEquals(cartCount, "1", "Cart count should be updated to 1.");
        }
    }


