package org.saucedemo.testscripts;

import org.saucedemo.pageobjects.*;
import org.saucedemo.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MultipleUsersSubmitOrderTest extends BaseTest {
    @Test(dataProvider = "getData")
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {

        InventoryPage inventoryPage = dashboardPage.validLogin(input.get("email"), input.get("password"));
        Assert.assertEquals("Products", dashboardPage.getProductTitle());
        inventoryPage.clickAllProducts();
        CartPage cartPage = new CartPage(driver);
        cartPage.ClickingCheckOutIcon();
        cartPage.ClickingCheckOutButton();
        CheckoutInformation checkoutInformation = new CheckoutInformation(driver);
        checkoutInformation.InputInfoFields("Nick4Testing","Testing4Nick","1218");
        checkoutInformation.ClickContinueButton();
        CheckOutOverViewPage checkOutOverViewPage = new CheckOutOverViewPage(driver);
        String totalAmount = checkOutOverViewPage.getTotalAmount();
        Assert.assertEquals("Total: $140.34", totalAmount);
        checkOutOverViewPage.clickFinishButton();
        CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage(driver);
        String completeOrder = checkOutCompletePage.getCompleteOrderText();
        Assert.assertEquals("Thank you for your order!",completeOrder);

    }

    @DataProvider
    public Object [] [] getData() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//org//saucedemo//data//UserAccounts.json");
        return new Object[][]  {{data.get(0)}, {data.get(1) }};

    }
}
