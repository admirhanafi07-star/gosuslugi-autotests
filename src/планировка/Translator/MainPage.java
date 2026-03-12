package Translator;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private  final SelenideElement theFirstHeadline = $x("//h1");

    public MainPage(String url){
        Selenide.open(url);
    }

    public String heading(){
        String result = theFirstHeadline.getText();
        System.out.println(result);
        boolean contains = result.contains("Подтвердите, что запросы отправляли вы, а не робот");
        System.out.println(contains);
        return result;
    }

}
