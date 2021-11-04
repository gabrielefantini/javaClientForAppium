import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Tests {

    @Test
    void insertNewNote() throws MalformedURLException {
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
        el3.sendKeys("New Note");
        MobileElement el4 = (MobileElement) driver.findElement(MobileBy.AccessibilityId("drawer open"));
        el4.click();
        Assert.assertEquals(driver.findElement(By.id("it.feio.android.omninotes.alpha:id/note_title")).getText(), "New Note");
    }

    @Test
    void archiveANote() throws MalformedURLException {
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
        el3.sendKeys("New Note");
        MobileElement el4 = (MobileElement) driver.findElement(MobileBy.AccessibilityId("drawer open"));
        el4.click();

        int screenWidth = (int) driver.manage().window().getSize().width;
        int screenWidth90 = (int) (.9 * screenWidth);
        int screenWidth65 = (int) (.65 * screenWidth);
        int screenWidth10 = (int) (.1 * screenWidth);

        MobileElement newNote = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/note_title"));

        TouchAction touchAction = new TouchAction(driver);
        int elementY = newNote.getLocation().getY();

        touchAction.press(PointOption.point(screenWidth90, elementY))
                .moveTo(PointOption.point(screenWidth65, elementY))
                .moveTo(PointOption.point(screenWidth10, elementY))
                .release()
                .perform();


        MobileElement el6 = (MobileElement) driver.findElement(MobileBy.AccessibilityId("drawer open"));
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout"));
        el7.click();

        Assert.assertEquals(driver.findElement(By.id("it.feio.android.omninotes.alpha:id/note_title")).getText(), "New Note");
    }

}

