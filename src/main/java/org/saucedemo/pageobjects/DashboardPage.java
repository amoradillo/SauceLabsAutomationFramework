package org.saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends Commons{

    public WebDriver driver;

    public DashboardPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id="user-name")
    WebElement loginUsername;


    @FindBy(id="password")
    WebElement loginPassword;

    @FindBy(id="login-button")
    WebElement loginButton;

    @FindBy(xpath="//span[@class='title']")
    WebElement productTitle;

    @FindBy(xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match a')]")
    WebElement loginErrorMessage;


   public InventoryPage validLogin(String username, String password)
   {
       loginUsername.sendKeys(username);
       loginPassword.sendKeys(password);
       loginButton.click();
       InventoryPage inventoryPage = new InventoryPage(driver);
       return inventoryPage;
   }

   public String getProductTitle()
   {
       waitForWebElementToAppear(productTitle);
       return productTitle.getText();
   }

   public String getErrorMessage()
   {
       waitForWebElementToAppear(loginErrorMessage);
       return loginErrorMessage.getText();
   }


   public void goTo()
   {
       driver.get("https://www.saucedemo.com/");
   }




}
