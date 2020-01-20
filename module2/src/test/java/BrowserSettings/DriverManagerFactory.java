package BrowserSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;

public class DriverManagerFactory {
    public static WebDriver getDriverManager(DriverType driverType) throws MalformedURLException {
        WebDriver driver;
        switch(driverType) {
            case CHROME:
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--no-sandbox");
                optionsChrome.addArguments("--remote-debugging-port=9222");
                optionsChrome.addArguments("--disable-notifications");
                driver = new ChromeDriver(optionsChrome);
                break;
            case FIREFOX:
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                driver = new FirefoxDriver(optionsFirefox);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + driverType);
        }
        return driver;
    }
}
