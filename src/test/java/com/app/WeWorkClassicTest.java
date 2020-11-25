package com.app;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//adb logcat ActivityManager:D *:S
//adb shell am start -S -W com.xueqiu.android/.view.WelcomeActivityAlias
//com.tencent.wework/.launch.WwMainActivity
public class WeWorkClassicTest {
    @Test
    void search() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","yy");
        capabilities.setCapability("appPackage","com.tencent.wework");
        capabilities.setCapability("appActivity",".launch.WwMainActivity");
        capabilities.setCapability("noReset","true");
        AppiumDriver<MobileElement> driver = new AppiumDriver<>(
                new URL("http://0.0.0.0:4723/wd/hub"),capabilities
        );
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        driver.findElement(MobileBy.id("guu")).click();
//        driver.findElement(MobileBy.id("gpg"))
    }
}






















