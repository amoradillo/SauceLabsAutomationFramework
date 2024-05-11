package org.saucedemo.testscripts;

import org.openqa.selenium.WebElement;
import org.saucedemo.pageobjects.CartPage;
import org.saucedemo.pageobjects.CheckoutInformation;
import org.saucedemo.pageobjects.InventoryPage;
import org.saucedemo.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MultipleUserLoginTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
    {

        InventoryPage inventoryPage = dashboardPage.validLogin("standard_user","secret_sauce");
        inventoryPage.clickAllProducts();
        Assert.assertEquals("Products", dashboardPage.getProductTitle());
        CartPage cartPage = new CartPage(driver);
        cartPage.ClickingCheckOutIcon();

    }

    @DataProvider
    public Object [] [] getData() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//org//saucedemo//data//UserAccounts.json");
        return new Object[][]  {{data.get(0)}, {data.get(1) }};

    }
}
