package saucedemotesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InvalidLoginAutomation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("user_John");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret1234");

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message-container error']/h3"))
        );
        String errorText = errorMessage.getText();
        System.out.println("Error message: " + errorText);

    }
}
