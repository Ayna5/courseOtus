import BrowserSettings.Browsers.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;

import java.net.MalformedURLException;

import static BrowserSettings.Browsers.ChromeDriver.getDriver;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

public class ChromeTest {
    private static final Logger logger = LogManager.getLogger(ChromeTest.class);

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        ChromeDriver.chromeSetting();
        logger.info("Браузер настроен и запущен - chrome");
        logger.error("Настройка браузера выполнена не успешно - chrome");
    }

    @Test
    public void openPage() {
        getDriver().manage().timeouts().pageLoadTimeout(5, SECONDS);
            try {
            getDriver().get("https://otus.ru/");
        } catch (TimeoutException ignore) {
        }
        assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям", getDriver().getTitle());
        logger.info("Страница открыта успешно - https://otus.ru/");
        logger.error("Страница открыта не успешно - https://otus.ru/");
    }

    @AfterClass
    public static void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
        logger.info("Браузер закрыт - chrome");
        logger.error("Браузер не закрыт - chrome");
    }
}
