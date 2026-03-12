package ПервыйАвтотестНаСеленид;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


abstract public class BaseTest {

    public void setUp(){
        // ✅ Selenide сам настроит драйвер
        System.setProperty("selenide.browser", "chrome");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";      // Размер окна
        Configuration.timeout = 4000;
        Configuration.headless = false;               // Показывать браузер
        Configuration.screenshots = true;             // Делать скриншоты при падении
    }

    @BeforeEach //Это то, что происходит до начала теста
    public void init(){
        setUp();
    }

    @AfterEach //Это то, что происходит после начала теста
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}













////WebDriverManager.chromedriver().setup();
// Пошагово:
// 1. Проверяет: есть ли chromedriver в кэше (~/.cache/selenium)?
// 2. Если нет → определяет версию Chrome
// 3. Скачивает chromedriver с официального сайта
// 4. Распаковывает (для Windows/Linux/macOS)
// 5. Устанавливает исполняемые права (для Linux/macOS)
// 6. Добавляет путь в System.setProperty()
////Но могут быть и другие браузеры:
//WebDriverManager.chromedriver().setup();      // Chrome
//WebDriverManager.firefoxdriver().setup();     // Firefox
//WebDriverManager.edgedriver().setup();        // Edge
//WebDriverManager.operadriver().setup();       // Opera

// Шаг за шагом в памяти: WebDriverManager.chromedriver().setup();
// 1. WebDriverManager - загружается класс в память
// 2. .chromedriver() - создается объект ChromeDriverManager
//    В памяти появляется: [ChromeDriverManager@5f184fc]
// 3. .setup() - вызывается метод у этого объекта
//    Объект выполняет все проверки и настройки
// 4. Результат: в системе появляется переменная
//    System.getProperty("webdriver.chrome.driver") = "/path/to/chromedriver"