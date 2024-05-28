package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    /**1. Create the package ‘browserfactory’ and create the
     class with the name ‘BaseTest’ inside the
     ‘browserfactory’ package. And write the browser setup
     code inside the class ‘Base Test’.
     2. Create the package ‘testsuite’ and create the
     following class inside the ‘testsuite’ package.

     1. LoginTest

     3. Write down the following test into ‘LoginTest’ class
     1. userSholdLoginSuccessfullyWithValid Credentials

     * Enter “standard_user” username
     * Enter “secret_sauce” password
     * Click on ‘LOGIN’ button
     * Verify the text “PRODUCTS”
     2. verifyThatSixProductsAreDisplayedOnPage

     * Enter “standard_user” username
     * Enter “secret_sauce” password
     * Click on ‘LOGIN’ button
     * Verify that six products are displayed on
     *
     */

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        driver.findElement(By.id("user-name")).sendKeys("visual_user");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on login button
        driver.findElement(By.id("login-button")).click();

        //Verify the text products
        String expectedText = "Products";
        WebElement welcomeText = driver.findElement(By.className("title"));
        String actualText = welcomeText.getText();
        Assert.assertEquals("Not expected text",expectedText,actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter username
        driver.findElement(By.id("user-name")).sendKeys("visual_user");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on login
        driver.findElement(By.id("login-button")).click();

        //Verify that six products are displayed on a page
        List<WebElement> products =driver.findElements(By.className("inventory_item"));
        int expectedProducts =6;
        Assert.assertEquals("User can not see six products ",expectedProducts,products.size());
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
