package org.saucedemo.testscripts;

import org.saucedemo.pageobjects.*;
import org.saucedemo.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartFunctionality extends BaseTest {


    @Test
    public void MultipleAddToCart() throws InterruptedException {
        InventoryPage inventoryPage = dashboardPage.validLogin("standard_user","secret_sauce");
        inventoryPage.clickAllProducts();
        Assert.assertEquals("Products", dashboardPage.getProductTitle());
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

}
