package Translator;

import org.junit.jupiter.api.Test;
import ПервыйАвтотестНаСеленид.BaseTest;

public class TranslatorTest extends BaseTest {

    private final static String URL = "https://translate.yandex.ru/";

    @Test
    public void test1() throws InterruptedException {
        String s = new MainPage(URL).heading();
    }
}
