package org.factories;

import org.config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;
import java.util.List;

public final class DriverFactory {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {
    }


    public static void initDriver() {
        if (driver.get() == null) {
            String browser = System.getProperty("browser", ConfigManager.getProperty("browser"));
            String headless = System.getProperty("headless", "false");

            List<String> validBrowsers = Arrays.asList("chrome", "firefox", "edge");
            if (!validBrowsers.contains(browser.toLowerCase())) {
                throw new IllegalArgumentException("⚠️ Invalid Browser: '" + browser + "'. Use: chrome, firefox or edge.");
            }
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    if (headless.equalsIgnoreCase("true")) {
                        chromeOptions.addArguments("--headless=new", "--window-size=1920,1080");
                    } else {
                        chromeOptions.addArguments("--start-maximized");
                    }
                    driver.set(new ChromeDriver(chromeOptions));
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (headless.equalsIgnoreCase("true")) {
                        firefoxOptions.addArguments("-headless");
                        firefoxOptions.addArguments("--width=1920", "--height=1080");
                    }
                    driver.set(new FirefoxDriver(firefoxOptions));
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (headless.equalsIgnoreCase("true")) {
                        edgeOptions.addArguments("--headless=new", "--window-size=1920,1080");
                    } else {
                        edgeOptions.addArguments("start-maximized");
                    }
                    driver.set(new EdgeDriver(edgeOptions));
                    break;
                default:
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
