import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String args[]) throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5559");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "it.feio.android.omninotes.alpha");
        dc.setCapability("appActivity", "it.feio.android.omninotes.MainActivity");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        MobileElement el1 = (MobileElement) driver.findElement(By.id("it.feio.android.omninotes.alpha:id/fab_expand_menu_button"));
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElement(By.id("it.feio.android.omninotes.alpha:id/fab_note"));
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElement(By.id("it.feio.android.omninotes.alpha:id/detail_title"));
        el3.click();
        el3.sendKeys("Madonna Puttana");
        MobileElement el4 = (MobileElement) driver.findElement(MobileBy.AccessibilityId("drawer open"));
        el4.click();
        Assert.assertEquals(driver.findElement(By.id("it.feio.android.omninotes.alpha:id/note_title")).getText(), "Madonna Puttana");
    }
}

