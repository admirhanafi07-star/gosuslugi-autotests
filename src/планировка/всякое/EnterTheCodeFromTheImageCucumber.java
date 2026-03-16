package org.example.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EnterTheCodeFromTheImageCucumber extends LoginRegistrationPageCucumber {

    public EnterTheCodeFromTheImageCucumber(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
