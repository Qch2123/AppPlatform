package com.fdzc.appback.service;

import com.fdzc.appback.entity.AppCategory;
import com.fdzc.appback.mapper.AppCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppCategoryService {
    @Autowired
    AppCategoryMapper appCategoryMapper;

    public AppCategory getTree() {
        List<AppCategory> list=appCategoryMapper.selectAll();

        AppCategory tree=new AppCategory();
        for (AppCategory appCategory : list) {
            if (appCategory.getParentid()==null) {
                tree=findChildren(appCategory,list);
            }
        }
        return tree;
    }

    private AppCategory findChildren(AppCategory appCategory, List<AppCategory> list) {
        appCategory.setChildren(new ArrayList<>());
        for (AppCategory category : list) {
            if(category.getParentid()==appCategory.getId()) {
                appCategory.getChildren().add(category);
                findChildren(category, list);
            }
        }
        return appCategory;
    }
}
