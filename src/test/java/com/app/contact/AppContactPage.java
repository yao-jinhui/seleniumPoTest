package com.app.contact;

import com.app.profile.AppBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AppContactPage extends AppBasePage {
    private By menu = By.id("gup");
    private By searchButton = By.id("guu");
    private By addDepartLocator = By.xpath("//*[@text='添加子部门']");
    private By editText = By.className("android.widget.EditText");
    private By departName = By.xpath("//android.widget.ListView/android.widget.TextView");
    private By closeButton = By.id("guk");

    public AppContactPage(AppiumDriver driver){
        super(driver);
    }


    public AppContactPage addDepart(String name){
        driver.findElement(menu).click();
        driver.findElement(addDepartLocator).click();
        driver.findElement(editText).sendKeys(name);
        driver.findElement(By.xpath("//*[@text='确定']")).click();
        driver.findElement(closeButton).click();
        return this;
    }

    public AppContactPage search(String keyword){
        driver.findElement(searchButton).click();
        driver.findElement(editText).sendKeys(keyword);
        return this;
    }

    public String getCurrentDepartName(){
        StringBuilder contents = new StringBuilder();
        driver.findElements(departName).forEach(element->{
            contents.append(((WebElement)element).getText());
        });
        System.out.println(contents);
        return contents.toString();
    }
}




















