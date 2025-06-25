package com.fdzc.appback;

import com.fdzc.appback.entity.AppCategory;
import com.fdzc.appback.mapper.AppCategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppbackApplicationTests {

    @Autowired
    AppCategoryMapper appCategoryMapper;

    @Test
    void contextLoads() {
        AppCategory appCategory = appCategoryMapper.selectByPrimaryKey(2L);
        System.out.println(appCategory);
    }

}
