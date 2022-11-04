package com.epam.maf.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.epam.maf.utilities.Config.BASE_URL;
import static com.epam.maf.utilities.Config.DEFAULT_BROWSER;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver()  {
        if (webDriver.get() == null) {
            webDriver.set(initializeDriver());
        }
        return webDriver.get();
    }

    private static WebDriver initializeDriver()  {
        WebDriver driver = null;

        switch (DEFAULT_BROWSER){
            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                chromeOptions.addArguments("--disable-web-security");
                chromeOptions.addArguments("--disable-extensions");
                driver = new ChromeDriver(chromeOptions);
                driver.get(BASE_URL);
                driver.manage().window().maximize();
                break;
            case  "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                firefoxOptions.addArguments("--disable-notifications");
                firefoxOptions.addArguments("--disable-blink-features=AutomationControlled");
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                driver.get(BASE_URL);
                driver.manage().window().maximize();
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                edgeOptions.setCapability("useAutomationExtension", false);
                driver = new EdgeDriver(edgeOptions);
                driver.get(BASE_URL);
                driver.manage().window().maximize();
                break;
            case "grid-firefox":
                FirefoxOptions firefoxOptions1 = new FirefoxOptions();
                firefoxOptions1.addArguments("start-maximized");
                firefoxOptions1.addArguments("--disable-blink-features=AutomationControlled");
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),firefoxOptions1);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.get(BASE_URL);
                driver.manage().window().maximize();
                break;
            case "grid-chrome":
                ChromeOptions chromeOptions1 = new ChromeOptions();
                chromeOptions1.addArguments("start-maximized");
                chromeOptions1.addArguments("--disable-blink-features=AutomationControlled");
                chromeOptions1.addArguments("--disable-web-security");
                chromeOptions1.addArguments("--disable-extensions");
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions1);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.get(BASE_URL);
                driver.manage().window().maximize();
                break;
        }
        return driver;
    }

    public static void quitDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
