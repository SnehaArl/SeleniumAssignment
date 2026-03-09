package saucedemotesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
        //------Login completed---------------

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/inventory.html"));

        WebElement sauceBackPack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        sauceBackPack.click();

        WebElement sauceShirt = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        sauceShirt.click();

        // Verify cart badge count
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        String itemCount = cartBadge.getText();

        if(itemCount.equals("2")) {
            System.out.println("Items successfully added to cart");
        } else {
            System.out.println("Cart item count mismatch");
        }

        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();

    }
}
