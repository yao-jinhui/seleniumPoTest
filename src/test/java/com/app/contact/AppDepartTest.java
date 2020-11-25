package com.app.contact;

import com.app.profile.AppMainPage;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppDepartTest {
    private static AppMainPage main;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        main = new AppMainPage();
    }

    @BeforeEach
    void beforeEach(){
        //进入入口
    }

    @AfterEach
    void afterEach(){
        //退到入口
    }

    @AfterAll
    static void afterAll(){
        //清理工作？其实不是，afterAll在测试用例出现异常，或者手工停止的时候，没法保证此过程一定会被调用
        //afterAll可以放到beforeAll中
        //套件的入口回退可以考虑用这个
    }

    @Test
    void add(){
        String name = "测试部001";
        assertTrue(main.contact().addDepart(name).search("001").getCurrentDepartName().contains(name));
    }

    @Test
    void search(String name){
        assertEquals(name,main.contact().addDepart(name).search(name).getCurrentDepartName());
    }














}
