import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static BrowserSettings.BrowserSettings.chromeSetting;
import static BrowserSettings.BrowserSettings.getDriver;


public class Tests {
    private String url;

    public Tests(String url) {
        this.url = url;
    }

    @BeforeClass
    public static void setUp() {
        chromeSetting();
    }

    @Parameters({"url"})
    @Test
    public void openPageWithChrome() {
        System.out.println("url: " + url);
        getDriver().get(url);
    }

    @AfterClass
    public static void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }


//    public String hostname() {
//        return null;
//    }
}
