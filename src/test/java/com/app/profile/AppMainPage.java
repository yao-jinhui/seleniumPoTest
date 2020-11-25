package com.app.profile;

import com.app.contact.AppContactPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppMainPage extends AppBasePage {
    public AppMainPage(AppiumDriver driver) {
        super(driver);
    }

    public AppMainPage() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","yy");
        capabilities.setCapability("appPackage","com.tencent.wework");
        capabilities.setCapability("appActivity",".launch.WwMainActivity");
        capabilities.setCapability("noReset","true");
        capabilities.setCapability("dontStopAppOnReset","true");//启动时不停当前的进程
        driver = new AppiumDriver<>(
                new URL("http://0.0.0.0:4723/wd/hub"),capabilities
        );
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        new WebDriverWait(driver,120
                ).until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='通讯录']")));
    }

    public AppContactPage contact(){
        driver.findElement(By.xpath("//*[@text='通讯录']")).click();
        return new AppContactPage(driver);
    }
}
