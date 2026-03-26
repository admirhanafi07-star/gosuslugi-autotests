package org.example.gosuslugi_selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

//// Главная страница сайта gosuslugi.ru
public class MainPage {

    public MainPage() {
        // Selenide сам инициализирует элементы
    }

    @FindBy(xpath = "//button[contains(@class, 'login-button')]")  // кнопка для перехода к авторизации
    private SelenideElement extensionLink;

    //Клик по кнопке для перехода на страницу регистраций
    public LoginPage clickExtensionLink() {
        extensionLink.click();
        return page(LoginPage.class);  // "Создай мне новый объект LoginPage, инициализируй в нём все @FindBy поля и верни его."
    }
//====================================================================================================================
    // Список (ссылки) всех элементов и их имена
    @FindBy(css = ".mr-24.ng-star-inserted")
    private List<SelenideElement> allElements;

    public MainPage printAllElements() {
        // Ждём загрузки меню
        $$(".mr-24.ng-star-inserted").shouldHave(sizeGreaterThan(0));
        System.out.println("✅ Меню загружено, элементов: " + $$(".mr-24.ng-star-inserted").size());
        System.out.println("\n══════════════════════════════════════════");
        // Прямой CSS-селектор
        List<String> texts = $$("button p.link-plain, a p.link-plain").texts();
        System.out.println("   Найдено элементов: " + texts.size());
        System.out.println("   Тексты элементов: " + texts);
        System.out.println("\n══════════════════════════════════════════");
        // Через stream()
        List<ElementsCollection> texts2 = allElements.stream().map(e -> e.$$("button p.link-plain, a p.link-plain")).collect(Collectors.toList());
        System.out.println("   Найдено элементов: " + texts2.size());
        List<String> texts3 = allElements.stream().map(e -> e.getText()).toList();
        System.out.println("   Тексты элементов: " + texts3);
        return this;
    }
//====================================================================================================================
    // Список (ссылки) всех href элементов и их имена
    @FindBy(css = ".mr-24.ng-star-inserted")
    private List<SelenideElement> allElementsHref;

    public MainPage openRandomElementsHref(){
        // Ждём загрузки страницы (появится хотя бы одна ссылка)
        $$("a").shouldHave(sizeGreaterThan(0));
        // Находим все элементы <a> на странице
        ElementsCollection allLinks = $$("a");
        System.out.println("📌 Всего найдено ссылок: " + allLinks.size());
        return this;
    }

    public MainPage openRandomElementsHref2(){
        // Ждём загрузки страницы (появится хотя бы одна ссылка)
        $$("a").shouldHave(sizeGreaterThan(0));
        // Создаём список для хранения href
        List<String> allLinks = $$("a").stream().map(e -> e.getAttribute("href")).collect(Collectors.toList());
        System.out.println(allLinks);
        List<String> allLinks2 =allElementsHref.stream().map(e -> e.getAttribute("href")).collect(Collectors.toList());
        System.out.println("Список всех href ссылок: " + allLinks2.size());

        return this;
    }
}
