package com.web.java;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

//        Map<String,String> map = new HashMap<>();
//        map.put("hello","world");
//        map.put("world","hello");
//        map.put("hello","world1");
//
//        map.get("hello");
        System.out.println(0x7fffffff);

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("hello","world");
        concurrentHashMap.put("world","hello");
        concurrentHashMap.put("hello1","world");
        concurrentHashMap.put("hello2","world");
        concurrentHashMap.put("hello","world");

        concurrentHashMap.get("hello1");
    }
}
