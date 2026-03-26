package gosuslugi_autotests_cucumber;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import static org.example.gosuslugi_cucumber.pages.CommonActionsSelenium.createDriverCucumber;

/**создаём драйвер (ОДИН раз)*/
public class Hooks {

    public static WebDriver driver;

    @Before
    public static void setUp() throws InterruptedException {
        driver = createDriverCucumber();

        // 2️⃣ Удалить все куки (сбрасываем историю неудачных попыток)
        driver.manage().deleteAllCookies();

        // 3️⃣ Обновить страницу, чтобы применить сброс
        driver.navigate().refresh();
    }

//    @After
//    public static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
