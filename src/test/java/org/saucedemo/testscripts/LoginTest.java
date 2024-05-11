package org.saucedemo.testscripts;

import org.openqa.selenium.WebDriver;
import org.saucedemo.pageobjects.CheckoutInformation;
import org.saucedemo.pageobjects.DashboardPage;
import org.saucedemo.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest
{

   @Test
   public void validUsername() throws InterruptedException
   {
      dashboardPage.validLogin("standard_user","secret_sauce");
      Assert.assertEquals("Products", dashboardPage.getProductTitle());

   }


}
