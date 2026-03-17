package gosuslugi_autotests_selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.selenide.pages.LoginPage;
import org.example.selenide.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

abstract public class BaseTest {
    private LoginPage loginPage;
    public MainPage mainPage;

    @BeforeEach
    public void init(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.screenshots = true;
    }

    @BeforeEach
    public void openPage() {
        open("https://www.gosuslugi.ru/");
        mainPage = page(MainPage.class);
    }

//    @AfterEach
//    public void tearDown(){
//        Selenide.closeWebDriver();
//    }
}
