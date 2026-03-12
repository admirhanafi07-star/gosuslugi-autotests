package hh;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JobSearch {

    private final SelenideElement numberinput = $x("//input[@inputmode=\"tel\"]");

    private final SelenideElement jobClick = $x("(//span[@class=\"magritte-button__content___BXYU0_7-0-6\"])[3]");

    public EnterTheCode applyFilter(String number){
        numberinput.setValue(number);
        jobClick.click();
        return new EnterTheCode(); // Остаемся на этой же странице!
    }
}
