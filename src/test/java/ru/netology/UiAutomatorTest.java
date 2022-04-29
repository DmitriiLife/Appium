package ru.netology;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UiAutomatorTest {

        private AndroidDriver driver;

    @BeforeAll
        public void setUp() throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:deviceName", "Pixel 2 API 30");
            desiredCapabilities.setCapability("appium:app", "Users/mac/desktop/app-debug.apk");
            desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
            desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
            desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
            desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

            URL remoteUrl = new URL("http://127.0.0.1:4722/wd/hub");

            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        }
    @Order(1)
    @Test
    public void firstTest() {
        String text = " ";
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.userInputButton.click();
        mainScreen.userInputButton.sendKeys(text);
        mainScreen.buttonChange.click();
        Assertions.assertNotEquals(text, mainScreen.textToBeChanged.getText());
    }

    @Order(2)
    @Test
    public void twoTest() {
        String text = "Hey, my friend!";
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.userInputButton.click();
        mainScreen.userInputButton.sendKeys(text);
        mainScreen.buttonActivity.click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.elementToBeClickable(mainScreen.textBox));
        Assertions.assertEquals(text, mainScreen.textBox.getText());
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
