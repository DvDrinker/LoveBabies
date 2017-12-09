package com.lanou.util;

import com.lanou.entity.CutPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanou on 2017/12/9.
 */
public class LimitPage {

    public List limitList(CutPage page,List limitedList){
        List newList = new ArrayList();
        for (int i = (page.getPage()-1)*page.getCOUNT();i<page.getPage()*page.getCOUNT();i++){
            if (i >= limitedList.size()){
                break;
            }
            else {
                newList.add(limitedList.get(i));
            }
        }

        return newList;
    }
}
