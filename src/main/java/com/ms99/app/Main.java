package com.ms99.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

/**
 * Created by massacre99 on 20.02.2018.
 */
public class Main {
    public static void main(String[] args) {

        WebDriver driver = initChromeDriver();

        driver.get("https://www.bing.com/");
        WebElement fieldSearch = driver.findElement(By.id("sb_form_q"));
        fieldSearch.sendKeys("selenium");

        WebElement button = driver.findElement(By.name("go"));
        button.click();

        List<WebElement> refers = driver.findElements(By.className("b_algo"));
        System.out.println(refers.size());

        driver.quit();
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}
