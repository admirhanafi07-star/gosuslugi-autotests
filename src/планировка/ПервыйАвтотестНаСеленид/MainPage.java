package ПервыйАвтотестНаСеленид;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

//// Главная страница сайта appleinsider.ru

public class MainPage {
    /*private final SelenideElement searchButton = $x("//form");*/
    private final SelenideElement textBoxInput = $x("//input[@type= \"text\"]");

    public MainPage(String url){
        Selenide.open(url);
    }

    /** Выполняется поиск на сайте среди статьей и нажимается ENTER
     * @param searchString поисковая строка
    */
    public SearchPage search(String searchString){
        textBoxInput.setValue(searchString);
        textBoxInput.sendKeys(Keys.ENTER);
        return new SearchPage();
    }























    /*public void search(String searchString){
        textBoxInput.setValue(searchString);
        textBoxInput.sendKeys(Keys.ENTER);
    }*/

    //// Псевдокод того, что происходит внутри Selenide:
    //public void setValue(String text) {
    //    element.click();       // 1. Сначала кликает на элемент (фокусирует его)
    //    element.clear();       // 2. Очищает поле если там что-то есть
    //    element.sendKeys(text); // 3. Вводит текст
    //}

    //Это ещё один вариант открытия страницы
    /*public void openWebSite(String url){
        Selenide.open(url);
    }*/


}
