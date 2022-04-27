package ru.netology;

import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class CalculatorTest {

    private IOSDriver driver;

    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("appium:deviceName", "iPhone 13");
        desiredCapabilities.setCapability("appium:bundleId", "com.shubham-iosdev.Calculator-UI");
        desiredCapabilities.setCapability("appium:automationName", "XCUITest");
        desiredCapabilities.setCapability("appium:includeSafariInWebviews", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new IOSDriver(remoteUrl, desiredCapabilities);
    }

        @Test
        public void sampleTest() {
            MainScreen mainScreen = new MainScreen(driver);
            mainScreen.digitOneButton.click();
            mainScreen.digitEightButton.click();
            mainScreen.digitMultiplyButton.click();
            mainScreen.digitFiveButton.click();
            mainScreen.digitShareButton.click();
            mainScreen.digitTwoButton.click();
            mainScreen.equalsSignButton.click();
            Assertions.assertEquals("45", mainScreen.resultField.getText());
        }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
