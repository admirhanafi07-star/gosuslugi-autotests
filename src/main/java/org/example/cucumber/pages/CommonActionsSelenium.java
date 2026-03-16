package org.example.cucumber.pages;

import org.example.cucumber.utils.ConfigCucumber;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.example.gosuslugi_autotests.Config.PLATFORM_AND_BROWSER;

public class CommonActionsSelenium {

    //1 вариант
    public static WebDriver createDriverCucumber() throws InterruptedException {

        WebDriver driver = null;
        switch (PLATFORM_AND_BROWSER) {
            case "windows_chrome":
                Thread.sleep(2000);
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigCucumber.IMPLICIT_WAIT));

        return driver;
    }
}
