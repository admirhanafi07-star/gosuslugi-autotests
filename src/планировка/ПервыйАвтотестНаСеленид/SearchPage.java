package ПервыйАвтотестНаСеленид;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage {

    private final ElementsCollection searchText = $$x("//h2//a");

    public String searchTextCollections(){
        return searchText.first().getAttribute("href");
    }
}


