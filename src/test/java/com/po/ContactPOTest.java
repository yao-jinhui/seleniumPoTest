package com.po;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPOTest {

    private static MainPage main;

    @BeforeAll
    static void beforeAll() throws IOException, InterruptedException {
        main = new MainPage();
        //为什么不放afterAll，如果你的用例中途被停止，teardown是不能保证一定会被执行，下次用例就会因为没清理数据导致失败
    }

    /***
     * 搜索部门
     */
    @Test
    void testDepartSearchChain() throws IOException, InterruptedException {
        assertTrue(main.contact().searchDepart("销售部").getPartyInfo().contains("无任何成员"));
    }

    /**
     * 添加部门
     * */
    @Test
    void addDepartTest() {
        String departName = "武装部";
        assertTrue(main.contact().addDepart(departName).searchDepart(departName).getPartyInfo().contains(departName));
    }

    /**
     * 添加成员
     * */
    @Test
    void addMemberTest(){
        main.contact().addMember("武装部","测试001","001001","13122220001");
        main.contact().addMember("武装部","测试002","001002","13122220002");
    }

    /**
     * 删除成员
     * */
    @Test
    void deleteMemberTest(){
        String departName = "武装部";
        assertTrue(main.contact().deleteMember(departName).searchDepart(departName).getPartyInfo().contains(departName));
    }

    /**
     * 删除部门
     * */
    @Test
    void deleteDepartTest(){
        String departName = "武装部";
        main.contact().deleteDepart(departName);
    }

}