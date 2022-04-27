package ru.netology;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainScreen {

    @iOSXCUITFindBy(accessibility = "1")
    public MobileElement digitOneButton;

    @iOSXCUITFindBy(accessibility = "2")
    public MobileElement digitTwoButton;

    @iOSXCUITFindBy(accessibility = "8")
    public MobileElement digitEightButton;

    @iOSXCUITFindBy(accessibility = "5")
    public MobileElement digitFiveButton;

    @iOSXCUITFindBy(accessibility = "/")
    public MobileElement digitShareButton;

    @iOSXCUITFindBy(accessibility = "*")
    public MobileElement digitMultiplyButton;

    @iOSXCUITFindBy(accessibility = "=")
    public MobileElement equalsSignButton;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    public MobileElement userInputButton;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    public MobileElement buttonActivity;

    @AndroidFindBy(id ="ru.netology.testing.uiautomator:id/text")
    public MobileElement textBox;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"C\"]/preceding::XCUIElementTypeStaticText)[last()]")
    public MobileElement resultField;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    public MobileElement buttonChange;

    @AndroidFindBy(id = "textToBeChanged")
    public MobileElement textToBeChanged;

    private AppiumDriver driver;

    public MainScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }
}
