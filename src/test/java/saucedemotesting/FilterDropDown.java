package saucedemotesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FilterDropDown {
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/inventory.html"));

        WebElement filterDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(By.className("product_sort_container"))
        );
        Select filter = new Select(filterDropdown);
        filter.selectByVisibleText("Name (Z to A)");
        System.out.println("Filter applied: Z to A");

        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
        List<String> productList = new ArrayList<>();
        for(WebElement product : productNames){
            productList.add(product.getText());
        }
        System.out.println("Products on page : " + productList);

        // Apply Price (low to high) filter
        WebElement dropDown = driver.findElement(By.className("product_sort_container"));
        Select sc = new Select(dropDown);
        sc.selectByVisibleText("Price (low to high)");
        System.out.println("Filter applied: Price Low to High");

        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<String> productPrices = new ArrayList<>();
        for (WebElement price : priceElements) {
            String priceText = price.getText();
            productPrices.add(priceText);
        }
        System.out.println("Prices on page : " + productPrices);

    }
}
