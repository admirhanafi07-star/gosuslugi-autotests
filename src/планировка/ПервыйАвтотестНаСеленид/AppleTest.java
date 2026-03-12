package ПервыйАвтотестНаСеленид;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppleTest extends BaseTest{

    private final static String BASE_URL = "https://appleinsider.ru/";
    private final static String SEARCH_STRING = "Чем iPhone 13 отличается от iPhone 12";
    private final static String EXPECTED_WORD = "iphone-12";

    @Test
    public void checkHref(){
        //Второй вариант
        /*Assert.assertTrue(new MainPage(BASE_URL)
                .search(SEARCH_STRING)
                .searchTextCollections()
                .contains(EXPECTED_WORD));*/
        /*//Первый вариант
        String mainPage = new MainPage(BASE_URL).search(SEARCH_STRING).searchTextCollections();
        Assert.assertTrue(mainPage.contains("iphone-13"));*/
    }
}
