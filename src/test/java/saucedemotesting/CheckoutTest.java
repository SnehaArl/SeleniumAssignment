package saucedemotesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //------Login completed---------------

        WebElement backpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        backpack.click();
        System.out.println("Product added");

        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        System.out.println("Entering checkout information");

        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Sneha");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Aryal");

        WebElement postalCode = driver.findElement(By.id("postal-code"));
        postalCode.sendKeys("17760");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        System.out.println("Checkout information finished");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement finishButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("finish"))
        );

        finishButton.click();

        WebElement confirmation = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("complete-header"))
        );

        String message = confirmation.getText();
        System.out.println(message);
    }
}

