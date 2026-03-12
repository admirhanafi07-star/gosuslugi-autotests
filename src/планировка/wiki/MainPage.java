package wiki;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;


public class MainPage {

    private  final ElementsCollection collection = $$x("//div[@id='toc']//a//span[@class=\"toctext\"]");

    private  final ElementsCollection ссылки = $$x("//div[@id='toc']//a");

    public MainPage(String url){
        Selenide.open(url);
    }

    public void collectionOfItems(){
        List<String> li = ссылки.stream().map(e -> e.getAttribute("href")).filter(href -> href != null).collect(Collectors.toList());
        System.out.println("Вот наш список элементов преобразованный в лист: " + li);
        System.out.println("Размер коллекции: " + collection.size());
    }

    public void collectionOfItems2(){
        List<String> li = collection.stream().map(e -> e.getText()).collect(Collectors.toList());
        System.out.println("Вот наш список элементов преобразованный в лист с полученнием текстов из листа: " + li);
        System.out.println("Размер коллекции: " + ссылки.size());
    }

    public void collectionOfItems3(){
        List<String> li = ссылки.stream().map(e -> e.getAttribute("href")).filter(href -> href != null).collect(Collectors.toList());
        System.out.println("Вот наш список элементов преобразованный в лист: " + li);

        for (int i = 0; i<li.size(); i++){
            String listUrl = li.get(i);
            Selenide.open("" + listUrl);
            String url = WebDriverRunner.getWebDriver().getCurrentUrl();
            Assertions.assertEquals(url, listUrl);
        }
    }



}
