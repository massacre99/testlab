package com.ms99.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.SkipException;

import java.util.List;

/**
 * Created by massacre99 on 20.02.2018.
 */
public class Main {
    public static void main(String[] args) {

        WebDriver driver = initChromeDriver();
//        WebDriver driver = getDriver();

        driver.get("https://www.bing.com/");
        WebElement fieldSearch = driver.findElement(By.id("sb_form_q"));
        fieldSearch.sendKeys("selenium");

        WebElement button = driver.findElement(By.name("go"));
        button.click();

        List<WebElement> refers = driver.findElements(By.className("b_algo"));
        System.out.println(refers.size());

        driver.quit();
    }

    // INIT 1
    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

    // INIT 2
    public static WebDriver getDriver() {
        // get driver path property
        String driverPath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
        if (driverPath == null) {
            throw new SkipException("Path to ChromeDriver is not specified");
        }
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}
