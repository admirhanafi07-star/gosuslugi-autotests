package org.example.gosuslugi_selenium;

public class Config {
    public static final String PLATFORM_AND_BROWSER = "windows_chrome";

    /** Для driver.manage().timeouts() Неявное ожидание - Вы задаете общее время, которое WebDriver будет ждать при каждом поиске элемента. Если элемент не найден сразу, драйвер периодически проверяет его наличие в течение заданного времени. Действует на протяжении всей жизни драйвера (или до изменения значения).*/
    public static final int IMPLICIT_WAIT = 10;

    /**Для WebDriverWait Явное ожидание - Вы задаете максимальное время ожидания (например, 10 секунд) и условие (например, появление элемента). Если элемент появится через 5 секунд — ожидание прекращается сразу, и код выполняется дальше. Если элемент не появится за 10 секунд — вы получите исключение (например, TimeoutException).*/
    public static final int EXPLICIT_WAIT = 6;

}
