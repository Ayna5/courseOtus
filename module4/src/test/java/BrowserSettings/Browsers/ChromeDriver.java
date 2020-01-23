package BrowserSettings.Browsers;

import BrowserSettings.WebDriverFactory;
import BrowserSettings.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;

public class ChromeDriver {
    private static WebDriver driver;

    ChromeDriver (WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static void setDriver(WebDriver driver) {
        ChromeDriver.driver = driver;
    }

    public static WebDriver chromeSetting() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        MutableCapabilities options = new ChromeOptions();
        options.setCapability("--no-sandbox", true);
        options.setCapability("--remote-debugging-port=9222", true);
        options.setCapability("--disable-notifications", true);
        WebDriver driver = WebDriverFactory.create(DriverType.CHROME, options);
        setDriver(driver);

        getDriver().manage().window().maximize();
        return getDriver();
    }
}
