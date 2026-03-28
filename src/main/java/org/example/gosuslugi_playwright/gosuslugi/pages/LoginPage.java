package org.example.gosuslugi_playwright.gosuslugi.pages;

import com.microsoft.playwright.Locator;
import lombok.extern.slf4j.Slf4j;
import org.example.gosuslugi_playwright.gosuslugi.base.BasePage;

@Slf4j
public class LoginPage extends BasePage {

    public LoginPage buttonRegister(){
        Locator butReg = page.locator("//button[text() = ' Зарегистрироваться '] ");
        butReg.click();
        log.info("Вот мы и на странице после нажатия кнопки регистрации");
        return this;
    }

    public RegistrationPage buttonRegister2(){
        buttonRegister();
        return new RegistrationPage();
    }


}
