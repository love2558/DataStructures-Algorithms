package com.web.java.LinearList.LinkedList.source;

/**
 * Created by lih on 2019/3/31.
 */
public class DoubleList {

    Node head;
    Node tail;
    int size;

    class Node{
        Node pre;
        Integer data;
        Node next;
        public Node(Node pre,Integer data,Node next){
            this.pre = pre;
            this.data = data;
            this.next = next;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Node node(int p){
        if(isEmpty()) return null;
        if(p > 0 && p < size){
            Node node = head;
            for (int i = 0; i < p; i++) {
                node = node.next;
            }
            return node;
        }
        return null;
    }

    public void linkBefore(Integer element,Node node){
        if(node == null) return;
        if(node.pre == null){
            Node newNode = new Node(null,element,node);
            head = newNode;
            size++;
        }else{
            Node newNode = new Node(node.pre,element,node);
            node.pre.next = newNode;
            node.pre = newNode;
            size++;
        }
    }

    public void print(String msg){
        if(msg != null) System.out.print(msg);
        if(isEmpty()) return;
        Node node = head;
        for (int i = 0; i < size; i++) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void add(Integer element){
        if(tail == null){
            Node node = new Node(null,element,null);
            head = node;
            tail = node;
            size++;
        }else {
            Node node = new Node(tail,element,null);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void addValue(Integer element,int p){
        Node node = node(p);
        if(node != null){
            linkBefore(element,node);
        }
    }

    public void deleteValue(int p){
        Node node = node(p);
        if(node != null){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }
    }

    public void sort(){
        if(isEmpty()) return;
        Node node = head;
        boolean isChange = true;
        while(node.next != null && isChange){
            isChange = false;
            for(Node i = head; i.next != null;i=i.next){
                if(i.data > i.next.data){
                    Integer temp = i.next.data;
                    i.next.data = i.data;
                    i.data = temp;
                    isChange = true;
                }
            }
        }
    }

}
