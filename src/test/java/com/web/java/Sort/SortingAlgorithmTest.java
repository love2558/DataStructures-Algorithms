package com.web.java.Sort;

import org.junit.Test;

import java.util.Stack;

/**
 * 排序算法 https://www.cnblogs.com/onepixel/articles/7674659.html
 */
public class SortingAlgorithmTest {

    public void print() {
        for (int i : arry) {
            System.out.print(i + " ");
        }
    }

//    public int[] arry = new int[]{3, 1, 2, 5, 7, 4, 9, 8, 6};
    public int[] arry = new int[]{5, 9, 7, 4, 5, 7, 6, 1, 9, 9, 7, 4};
//    public int[] arry = new int[]{ 1,2,3,4,5,6,9,8,7};

    /**
     * 冒泡排序
     */
    @Test
    public void testBubble() {
        boolean flag = true;
        int n = 0;
        for (int i = 0; i < arry.length - 1; i++) {
            for (int j = 0; j < arry.length - i - 1; j++) {
                if (arry[j] > arry[j + 1]) {
                    int temp = arry[j];
                    arry[j] = arry[j + 1];
                    arry[j + 1] = temp;
                    flag = false;
                    n++;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(n);
        print();
    }

    /**
     * 选择排序
     * 与冒泡排序的不同：不用每次比较后，都做交换，而是最后一次性作交换
     */
    @Test
    public void testSelect() {
        for (int i = 0; i < arry.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arry.length; j++) {
                if (arry[index] > arry[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = arry[i];
                arry[i] = arry[index];
                arry[index] = temp;
            }
        }
        print();
    }

    /**
     * https://blog.csdn.net/qq_39404258/article/details/81806431
     */
    @Test
    public void fastSortTest() {
        fastSort1(arry, 0, arry.length - 1);
        print();
    }

    public void fastSort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];

        while (end > start) {
            //从后往前比较 找比key小的数
            while (end > start && a[end] >= key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较 找比key大的数
            while (end > start && a[start] <= key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //此时 start == end

        //递归
        if (start > low){
            fastSort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        }
        if (end < high){
            fastSort(a, end + 1, high);//右边序列。从关键值索引+1到最后一个
        }
    }

    public static void fastSort1(int[] array,int low,int high){
        int start = low;
        int end = high;
        int key = array[low];
        while(end > start){
            while(end > start && array[end] >= key){
                end--;
            }
            if(array[end] <= key){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
            while(end > start && array[start] <= key){
                start++;
            }
            if(array[start] >= key){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }

        if(start > low){
            fastSort1(array,low,start-1);
        }
        if(end < high){
            fastSort1(array,end+1,high);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        System.out.println(stack.pop());
    }
}
