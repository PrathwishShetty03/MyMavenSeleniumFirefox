package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {

        // Setup Chrome in headless mode (IMPORTANT for Jenkins)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");                  // Run without UI
        options.addArguments("--no-sandbox");                // Required in Jenkins/Linux
        options.addArguments("--disable-dev-shm-usage");     // Prevent memory issues
        options.addArguments("--remote-allow-origins=*");    // Fix Chrome compatibility

        WebDriver driver = new ChromeDriver(options);

        try {
            // Open website
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.manage().window().maximize();

            // Perform login
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            // Wait for page to load (simple wait)
            Thread.sleep(3000);

            System.out.println("✅ Login test executed successfully!");

        } catch (Exception e) {
            System.out.println("❌ TEST FAILED: " + e.getMessage());
        } finally {
            // Always close browser
            driver.quit();
        }
    }
}
