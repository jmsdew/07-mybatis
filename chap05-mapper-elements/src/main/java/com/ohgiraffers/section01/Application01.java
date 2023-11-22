package com.ohgiraffers.section01;

import com.ohgiraffers.section01.DTO.CategoryDTO;
import com.ohgiraffers.section01.DTO.MenuAndCategory;

import static com.common.Template.*;
public class Application01 {
    public static void main(String[] args){

        ElementsTestService service = new ElementsTestService();

        //       service.selectResultMapTest();
/*        MenuAndCategory menu = new MenuAndCategory();
        menu.getCategory().setCode();*/
        // menu = menuAndCategory의 heap의 주소값에 접근
        // menu.getCategory() return category(type categoryDTO)

 //       service.selectResultMapAssociationTest();

 //       service.selectResultMapCollectionTest();

//        service.selectSqlTest();

        MenuAndCategory menuAndCategory = new MenuAndCategory();
        menuAndCategory.setName("베이글 햄버거");
        menuAndCategory.setPrice(3000);
        menuAndCategory.setOrderableStatus("Y");
        menuAndCategory.setCategory(new CategoryDTO("신규 카테고리"));
        service.insertNewMenu(menuAndCategory);

    }
}
