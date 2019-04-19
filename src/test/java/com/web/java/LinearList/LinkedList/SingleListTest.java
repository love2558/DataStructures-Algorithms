package com.web.java.LinearList.LinkedList;

import com.web.java.LinearList.LinkedList.source.SingleList;
import org.junit.Before;
import org.junit.Test;

public class SingleListTest {

    private SingleList list;

    @Before
    public void before(){
        list = new SingleList();
        list.add(9);
        list.add(3);
        list.add(7);
        list.add(1);
        list.add(6);
        list.add(8);
        list.add(5);
        list.add(2);
        list.print("list初始化后为：");
    }

    @Test
    public void testAdd(){
        list.addValue(5,2);
        list.print("list在position：2，添加值5：");
    }

    @Test
    public void testSort(){
        list.sort();
        list.print("list冒泡排序后为：");
    }

    @Test
    public void testDelete(){
        list.deleteValue(3);
        list.print("list删除position:3的值：");
    }

    /**
     * 链表反转  1->2->3->4  =>   4->3->2->1
     */
    @Test
    public void testRevert(){

    }
}
