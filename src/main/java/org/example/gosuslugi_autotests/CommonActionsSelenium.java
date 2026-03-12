package org.example.gosuslugi_autotests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.example.gosuslugi_autotests.Config.PLATFORM_AND_BROWSER;

public class CommonActionsSelenium {

    //1 вариант
    public static WebDriver createDriver() throws InterruptedException {

        WebDriver driver = null;
        switch (PLATFORM_AND_BROWSER) {
            case "windows_chrome":
                Thread.sleep(1000);
                driver = new ChromeDriver();
                break;

            case "windows_firefox":
                driver = new FirefoxDriver();
                break;

            case "mac_chrome":
                // Для MacOS тоже можно добавить
                driver = new ChromeDriver();
                break;

            case "linux_chrome":
                // Для Linux
                driver = new ChromeDriver();
                break;

            default:
                throw new IllegalArgumentException("Данная платформа не поддерживается: " + PLATFORM_AND_BROWSER);
        }

        // Настройка драйвера
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.IMPLICIT_WAIT));

        return driver;
    }

    //2 вариант
    /*protected WebDriver webDriver; // protected чтобы был доступен наследникам

    @Before // Выполняется перед каждым тестом
    public void setUp() {
        String browser = Constant.WEBDRIVER;

        if (browser.equalsIgnoreCase("chrome")) {
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            webDriver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Неподдерживаемый браузер: " + browser);
        }

        webDriver.manage().window().maximize();
    }

    public void open(String url) {
        webDriver.get(url);
    }

    @After // Выполняется после каждого теста
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }*/
}
