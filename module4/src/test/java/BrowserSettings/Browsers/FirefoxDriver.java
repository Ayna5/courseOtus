package BrowserSettings.Browsers;

import BrowserSettings.WebDriverFactory;
import BrowserSettings.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;

public class FirefoxDriver {
    private static WebDriver driver;

    FirefoxDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static void setDriver(WebDriver driver) {
        FirefoxDriver.driver = driver;
    }

    public static WebDriver firefoxSetting() throws MalformedURLException {
        WebDriverManager.firefoxdriver().setup();
        MutableCapabilities options = new FirefoxOptions();
        options.setCapability("--no-sandbox", true);
        options.setCapability("--remote-debugging-port=9222", true);
        options.setCapability("--disable-notifications", true);

        WebDriver driver = WebDriverFactory.create(DriverType.FIREFOX, options);
        setDriver(driver);

        getDriver().manage().window().maximize();
        return getDriver();
    }
}
