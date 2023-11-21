package com.ohgiraffers.section03.remix;

import com.ohgiraffers.section03.remix.controller.MenuController;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args){

        MenuController menu = new MenuController();
        Map<String,String> value = new HashMap<>();
/*        value.put("code", "7");
        menu.selectMenuByCode(value);
        value.put("name", "보리새우떡");
        value.put("price", "5000");
        value.put("category", "5");
        menu.registMenu(value);*/
        menu.selectAllMenu();
    }

}
