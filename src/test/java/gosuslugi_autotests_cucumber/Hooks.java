package gosuslugi_autotests_cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import static org.example.cucumber.pages.CommonActionsSelenium.createDriverCucumber;

/**создаём драйвер (ОДИН раз)*/
public class Hooks {

    public static WebDriver driver;

    @Before
    public static void setUp() throws InterruptedException {
        // Инициализация драйвера перед каждым сценарием
        driver = createDriverCucumber();
    }

//    @After
//    public static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
