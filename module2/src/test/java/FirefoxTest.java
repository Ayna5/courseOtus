import BrowserSettings.Browsers.FirefoxDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;

import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static BrowserSettings.Browsers.FirefoxDriver.getDriver;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

public class FirefoxTest {
    private static final Logger logger = LogManager.getLogger(FirefoxTest.class);

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        FirefoxDriver.firefoxSetting();
        logger.info("Браузер firefox настроен и запущен");
        logger.error("Настройка браузера firefox выполнена не успешно");
    }

    @Test
    public void openPage() {
        getDriver().manage().timeouts().pageLoadTimeout(5, SECONDS);
        try {
            getDriver().get("https://otus.ru/");
        } catch (TimeoutException ignore) {
        }
        assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям", getDriver().getTitle());
        logger.info("Страница" + "открыта успешно");
        logger.error("Страница" + "открыта не успешно");
    }

    @AfterClass
    public static void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
        logger.info("Браузер firefox закрыт");
        logger.error("Браузер firefox не закрыт");
    }
}
