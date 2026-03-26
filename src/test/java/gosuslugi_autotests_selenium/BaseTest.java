package gosuslugi_autotests_selenium;

import io.qameta.allure.Step;
import org.example.gosuslugi_selenium.CommonActionsSelenium;
import org.example.gosuslugi_selenium.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @Step("Запуск браузера и открытие главной страницы Госуслуг")
    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = CommonActionsSelenium.createDriver();
        mainPage = new MainPage(driver); // Инициализируем здесь!
        mainPage.open("https://www.gosuslugi.ru/");
    }

    /*@AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Раскомментируйте, когда нужно закрывать браузер
        }
    }*/

}