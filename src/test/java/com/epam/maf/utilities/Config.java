package com.epam.maf.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.epam.maf.utilities.DriverFactory.getDriver;

public class Config {

    public static final String DEFAULT_BROWSER ;
    public static final String BASE_URL ;

    static {
        DEFAULT_BROWSER = getDefaultBrowser();
        BASE_URL = getBaseUrl();
    }

    public static String getBaseUrl() {
        String baseUrl = System.getProperties().getProperty("baseUrl");
        if(baseUrl == null) {
            baseUrl = addProperty().getProperty("baseUrl");
        }
        else {
            throw new RuntimeException("BaseUrl not specified in the configs.properties file.");
        }
        return baseUrl;
    }

    private static String getDefaultBrowser() {
        String browserName = System.getProperties().getProperty("browser");
        if(browserName == null) {
            browserName = addProperty().getProperty("browser");
        }
        return browserName;
    }

    private static Properties addProperty() {
        String filePath = "browser.properties";
        InputStream in = ClassLoader.getSystemResourceAsStream(filePath);
        Properties properties = new Properties();

        try {
            properties.load(in);
        } catch (IOException ioe) {
            throw new IllegalStateException("Exception on loading {" + filePath + "} conf file from classpath", ioe);
        }
        return properties;
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName){

        try {
            TakesScreenshot ts = (TakesScreenshot) getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));
        }catch (Exception e){
            System.out.println("Error while Screenshot" + e.getMessage());
        }
    }
}
