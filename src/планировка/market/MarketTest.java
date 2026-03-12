package market;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wiki.MainPage;
import ПервыйАвтотестНаСеленид.BaseTest;

public class MarketTest extends BaseTest {

    private final static String URL = "https://market.yandex.ru/";

    @Test
    @DisplayName("Открыть главную страницу по url")
    public void test1(){
        MainPage mainPage = new MainPage(URL);
    }
}
