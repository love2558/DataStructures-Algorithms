package com.web.java.LinearList.LinkedList;

import java.awt.peer.ListPeer;
import java.io.FileReader;

/**
 * Created by lih on 2019/3/31.
 * 单链表
 */
public class SingleList {

    Node head;
    Node tail;
    int size;

    class Node{
        Integer data;
        Node next;
        public Node(Integer data,Node next){
            this.data = data;
            this.next = next;
        }
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    //找出P位置的node
    public Node node(int p){
        if(p < this.size){
            Node x = head;
            for (int i = 0; i < p; i++) {
                x = x.next;
            }
            return x;
        }
        return null;
    }

    public void add(Integer element){
        if(tail == null){
            Node node = new Node(element,null);
            head = tail = node;
        }else{
            Node node = new Node(element,null);
            tail.next = node;
            tail = node;
        }
        this.size++;
    }

    //1.p位置新增元素
    public void addValue(Integer element,int p){
        Node n = node(p-1);
        if(n != null){
            linkAfter(element,n);
        }
    }

    public void linkAfter(Integer element,Node n){
        Node node = new Node(element,n.next);
        n.next = node;
        size++;
    }

    //2.p位置删除元素
    public void deleteValue(int p){
        Node before = node(p-1);
        Node n = node(p);
        before.next = n.next;
        size--;
    }

    public void print(){
        if(isEmpty()) return;
        Node x = head;
        for (int i = 0; i < this.size; i++) {
            System.out.print(x.data + " ");
            x = x.next;
        }
        System.out.println();
    }

    //3.排序
    public void sort(){
        Node node = head;
        boolean isChange = true;
        while(node.next != null && isChange){
            isChange = false;
            for (Node i = head; i.next != null; i = i.next) {
                if(i.data > i.next.data){
                    Integer temp = i.data;
                    i.data = i.next.data;
                    i.next.data = temp;
                    isChange = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        SingleList list = new SingleList();
        list.add(9);
        list.add(3);
        list.add(7);
        list.add(1);
        list.print();

        list.addValue(5,2);
        list.print();

        list.sort();
        list.print();

        list.deleteValue(3);
        list.print();


    }
}
