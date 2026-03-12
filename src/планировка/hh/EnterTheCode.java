package hh;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EnterTheCode {

    private final SelenideElement numbercode = $x("//input[@name=\"code\"]");

    public EnterTheCode applyCode(String cmc){
        numbercode.setValue(cmc);
        return this; // Остаемся на этой же странице!
    }
}
