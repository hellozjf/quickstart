package com.hellozjf.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map map = new HashMap();
        String str = "hello world";
        map.put("1", str);
        System.out.println(map.get("1"));
    }
}
