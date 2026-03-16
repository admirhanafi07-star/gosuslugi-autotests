package org.example.cucumber;/*
package org.example.driver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;


public class CommonActionsSelenide {
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
*/
