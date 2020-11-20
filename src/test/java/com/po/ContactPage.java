package com.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {
    //po原则2 不要暴露页面内部实现细节
    private By parterInfo=By.cssSelector(".js_party_info");

    public ContactPage(WebDriver driver) {
        //保存driver到自己的实例
        super(driver);
    }

    //po原则6 添加成功的时候与添加失败返回的页面是不同，需要封装为不同的方法
    public ContactPage addMemberSu(String username, String acctid, String mobile) {
        return this;
    }

    //po原则6 添加失败返回的页面是不同，需要封装为不同的方法
    public ContactPage addMemberFail(String username, String acctid, String mobile){
        return this;
    }

    //po原则5 不要实现所有的方法，按需封装
    public ContactPage searchDepart(String departName){
        //po原则1 用公共方法代表页面所提供的功能
        //po原则3  通常不要在po方法内添加断言
        sendKeys(By.id("memberSearchInput"), departName);
        String content = driver.findElement(parterInfo).getText();
        System.out.println(content);
        click(By.cssSelector(".ww_icon_AddMember"));
        return this;
    }

    public String getPartyInfo(){
        //
        String content = driver.findElement(parterInfo).getText();
        System.out.println(content);
        return content;
    }

    /**
     * 添加部门
     */
    public ContactPage addDepart(String departName) {
//        todo: 添加部门
        click(By.linkText("添加"));
        click(By.linkText("添加部门"));
        sendKeys(By.name("name"), departName);
        click(By.linkText("选择所属部门"));
        clicks(By.linkText("金梦集团"),1);
        click(By.linkText("确定"));
        return this;
    }

    /**
     * 添加成员
     * */
    public ContactPage addMember(String departName, String username, String acctid, String mobile) {
        try {
            click(By.linkText(departName));
            Thread.sleep(3000);
            clicks(By.linkText("添加成员"),0);
            Thread.sleep(4000);
            sendKeys(By.name("username"), username);
            sendKeys(By.name("acctid"), acctid);
            sendKeys(By.name("mobile"), mobile);
            click(By.linkText("保存"));
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 删除成员
     * */
    public ContactPage deleteMember(String departName) {
        try {
            click(By.linkText(departName));
            Thread.sleep(4000);
            click(By.xpath("//input[@class='ww_checkbox']"));
            click(By.linkText("删除"));
            click(By.linkText("确认"));
            click(By.linkText(departName));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 删除部门
     */
    public ContactPage deleteDepart(String departName) {
        try {
            click(By.linkText(departName));
            Thread.sleep(3000);
            click(By.xpath("//li[@class='jstree-node js_editable jstree-leaf jstree-last']//a//span"));
            Thread.sleep(2000);
            click(By.linkText("删除"));
            Thread.sleep(2000);
            click(By.linkText("确定"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

}
