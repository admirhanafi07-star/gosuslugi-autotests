package gosuslugi_autotests_selenide;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.title;

public class GosuslugiAutoTest extends BaseTest {

    @Test
    @DisplayName("🔐 Открытие ссылки")
    void test1() {
        // 1. Срабатывает вот этот вызов open("https://www.gosuslugi.ru/");
        // 2. Текущий URL
        System.out.println("📌 Текущий URL: " + WebDriverRunner.url());
    }

    @Test
    @DisplayName("🔐 Получить список элементов")
    void test2() {
        System.out.println("\n🔍 ДИАГНОСТИКА СТРАНИЦЫ");
        System.out.println("══════════════════════════════════════════");
        // 1. Заголовок страницы
        System.out.println("📌 Заголовок: " + title());
        // 2. Поиск элементов по разным селекторам
        System.out.println("\n🔍 ПОИСК ЭЛЕМЕНТОВ:");
        // Поиск по тегу li
        $$("li").shouldHave(sizeGreaterThan(0));
        int liCount = $$("li").size();
        System.out.println("📌 Всего li: " + liCount);
        // Поиск по классу mr-24
        $$(".mr-24").shouldHave(sizeGreaterThan(0));
        int mr24Count = $$(".mr-24").size();
        System.out.println("📌 Элементов с классом mr-24: " + mr24Count);
        // Поиск по классу link-plain
        $$(".link-plain").shouldHave(sizeGreaterThan(0));
        int linkPlainCount = $$(".link-plain").size();
        System.out.println("📌 Элементов с классом link-plain: " + linkPlainCount);
        // Поиск p.link-plain
        $$("p.link-plain").shouldHave(sizeGreaterThan(0));
        int pLinkPlainCount = $$("p.link-plain").size();
        System.out.println("📌 p.link-plain: " + pLinkPlainCount);

    }

    @Test
    @DisplayName("🔐 Переход на страницу регистраций")
    void test3() {
        mainPage.clickExtensionLink();
    }

    @Test
    @DisplayName("🔐 Получить список элементов")
    void test4() {
        mainPage.printAllElements();
    }
}