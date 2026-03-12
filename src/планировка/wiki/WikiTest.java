package wiki;

import org.junit.jupiter.api.Test;
import ПервыйАвтотестНаСеленид.BaseTest;

public class WikiTest extends BaseTest {

    private final static String URL = "https://ru.wikipedia.org/wiki/Java";

    @Test
    public void Получитьссылки(){
        MainPage mainPage = new MainPage(URL);
        mainPage.collectionOfItems();
        int a;
    }

    @Test
    public void Получитьтекст(){
        MainPage mainPage = new MainPage(URL);
        mainPage.collectionOfItems2();
        int a;
    }

    @Test
    public void ПолучитьУрл(){
        MainPage mainPage = new MainPage(URL);
        mainPage.collectionOfItems3();
        int a;
    }
}
