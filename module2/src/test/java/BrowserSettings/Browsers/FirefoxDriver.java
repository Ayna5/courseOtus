package BrowserSettings.Browsers;

import BrowserSettings.DriverManagerFactory;
import BrowserSettings.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

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

        WebDriver driver = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
        setDriver(driver);

        getDriver().manage().window().maximize();
        return getDriver();
    }
}
