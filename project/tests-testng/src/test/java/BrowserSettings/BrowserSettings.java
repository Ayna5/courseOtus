package BrowserSettings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSettings {
    private static WebDriver driver;

    public BrowserSettings(WebDriver driver) { BrowserSettings.driver = driver; }

    public static WebDriver getDriver() {
        return driver;
    }

    private static void setDriver(WebDriver driver) {
        BrowserSettings.driver = driver;
    }

    public static WebDriver chromeSetting() {
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static WebDriver firefoxSetting() {
        WebDriverManager.firefoxdriver().setup();
        setDriver(new FirefoxDriver());
        getDriver().manage().window().maximize();
        return getDriver();
    }
}
