package hh;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

//// Страница авторизации сайта hh.ru
public class HhResumePage {

    private final SelenideElement spanClick = $x("(//span[@class=\"magritte-button__label___zplmt_7-0-6\"])[1]");

    public HhResumePage(String url) {
        Selenide.open(url);
    }

    public HhAccount clickResumeButton(){
        spanClick.click();
        return new HhAccount(); // Переходим на страницу аккаунта
    }
}
