package org.example.gosuslugi_autotests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EnterTheCodeFromTheImage extends LoginRegistrationPage{

    public EnterTheCodeFromTheImage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
