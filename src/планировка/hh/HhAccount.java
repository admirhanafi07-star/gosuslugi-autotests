package hh;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HhAccount {
    private final SelenideElement spanClick = $x("(//span[@class=\"magritte-button__label___zplmt_7-0-6\"])[1]");

    public JobSearch clickSearchButton(){
        spanClick.click();
        return new JobSearch();  // Переходим на страницу поиска работы
    }
}
