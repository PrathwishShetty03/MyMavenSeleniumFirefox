package com.example; 
  
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.Dimension; 
import org.openqa.selenium.JavascriptExecutor; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.firefox.FirefoxOptions; 
import org.openqa.selenium.WindowType; 
import org.openqa.selenium.support.ui.WebDriverWait; 
import org.openqa.selenium.support.ui.ExpectedConditions; 
import java.time.Duration; 
  
public class App { 
    public static void main(String[] args) throws InterruptedException { 
  
        // Configure Firefox options 
        FirefoxOptions options = new FirefoxOptions(); 
  
        // Launch Firefox browser 
        WebDriver driver = new FirefoxDriver(options); 
        driver.manage().window().setSize(new Dimension(1920, 1080)); 
        System.out.println("Browser started"); 
  
        // -------- TAB 1: AutomationExercise -------- 
        driver.get("https://automationexercise.com/"); 
        Thread.sleep(3000); 
        System.out.println("Site 1 loaded"); 

 
        // Remove iframe advertisements using JavaScript 
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("document.querySelectorAll('iframe').forEach(e => e.remove());"); 
  
        // Locate and click the first product 
        WebElement element = driver.findElement(By.cssSelector("a[data-product-id='1']")); 
        js.executeScript("arguments[0].scrollIntoView(true);", element); 
        js.executeScript("arguments[0].click();", element); 
        System.out.println("Clicked product on Site 1"); 
  
        // -------- TAB 2: PracticeTestAutomation -------- 
        driver.switchTo().newWindow(WindowType.TAB); 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
        driver.get("https://practicetestautomation.com/practice-test-login/"); 
        System.out.println("Site 2 opened"); 
  
        wait.until(ExpectedConditions.titleContains("Login")); 
        wait.until(ExpectedConditions.presenceOfElementLocated( 
            By.id("username"))).sendKeys("student"); 
        driver.findElement(By.id("password")).sendKeys("Password123"); 
        driver.findElement(By.id("submit")).click(); 
        System.out.println("Logged into Site 2"); 
  
        // -------- TAB 3: SauceDemo -------- 
        driver.switchTo().newWindow(WindowType.TAB); 
        Thread.sleep(2000); 
        driver.get("https://www.saucedemo.com/"); 
        Thread.sleep(2000); 
  
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); 
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); 
        driver.findElement(By.id("login-button")).click(); 
        System.out.println("Logged into Site 3"); 
  
        Thread.sleep(5000); 
        driver.quit(); 
        System.out.println("Browser closed"); 
    }} 

