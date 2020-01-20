package BrowserSettings.Browsers;

import BrowserSettings.DriverManagerFactory;
import BrowserSettings.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

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

        WebDriver driver = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        setDriver(driver);

        getDriver().manage().window().maximize();
        return getDriver();
    }
}
