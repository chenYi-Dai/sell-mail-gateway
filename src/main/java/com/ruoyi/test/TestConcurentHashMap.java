package com.ruoyi.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurentHashMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> hashMap = new ConcurrentHashMap<>();
        hashMap.put("12","asd");
        System.out.println(hashMap);

        HashMap<Object,String> map = new HashMap<>();
        map.put("a","askjd");
        map.put(97,"ksd");
        System.out.println(map);

    }

}
