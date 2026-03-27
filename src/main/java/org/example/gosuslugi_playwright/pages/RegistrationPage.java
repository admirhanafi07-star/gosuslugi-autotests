package org.example.gosuslugi_playwright.pages;

import com.microsoft.playwright.Locator;
import lombok.extern.slf4j.Slf4j;
import org.example.gosuslugi_playwright.base.BasePage;

@Slf4j
public class RegistrationPage extends BasePage {

    public RegistrationPage buttonRegister3(){
        Locator butReg = page.locator("//button[text() = ' Другой способ регистрации '] ");
        butReg.click();
        log.info("Вот мы и на странице после нажатия кнопки регистрации");
        return this;
    }
}
