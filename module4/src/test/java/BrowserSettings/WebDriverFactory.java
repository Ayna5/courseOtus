package BrowserSettings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;

public class WebDriverFactory {
    public static WebDriver create(DriverType webDriverName) throws MalformedURLException {
        WebDriver driver;
        switch(webDriverName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--no-sandbox");
                optionsChrome.addArguments("--remote-debugging-port=9222");
                optionsChrome.addArguments("--disable-notifications");
                driver = new ChromeDriver(optionsChrome);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                driver = new FirefoxDriver(optionsFirefox);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + webDriverName);
        }
        return driver;
    }

    public static WebDriver create(DriverType webDriverName, MutableCapabilities options) throws MalformedURLException {
        WebDriver driver;
        switch(webDriverName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
//                ChromeOptions optionsChrome = new ChromeOptions();
//                optionsChrome.addArguments("--no-sandbox");
//                optionsChrome.addArguments("--remote-debugging-port=9222");
//                optionsChrome.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
//                FirefoxOptions optionsFirefox = new FirefoxOptions();
                driver = new FirefoxDriver(options);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + webDriverName);
        }
        return driver;
    }
}
