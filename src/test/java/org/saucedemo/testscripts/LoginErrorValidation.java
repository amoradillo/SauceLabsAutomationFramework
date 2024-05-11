package org.saucedemo.testscripts;

import org.saucedemo.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginErrorValidation extends BaseTest {



   @Test
   public void LoginErrorValidation()
   {
       dashboardPage.validLogin("standard_user", "secret_sau");
       Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", dashboardPage.getErrorMessage());
   }

}
