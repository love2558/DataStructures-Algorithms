package com.web.java.LinearList.ArrayList.source;

/**
 * Created by lih on 2019/3/31.
 */
public class ArrayListSelf<E> {

    Object[] data;
    int size;

    public ArrayListSelf(){
        this(0);
    }

    public ArrayListSelf(int capacitory){
        if(capacitory < 0){
            throw new IllegalArgumentException("capacitory should greater 0");
        }
        this.data = new Object[capacitory];
    }

    /**
     * 1.判断list是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * 2.查找值为x的元素
     * @param element
     * @return
     */
    public int getPosition(E element){
        if(isEmpty()) return -1;
        if(element == null){
            for (int i = 0; i < this.size; i++) {
                if(this.data[i] == null){
                    return i;
                }
            }
        }else{
            for (int i = 0; i < this.size; i++) {
                if(element.equals(this.data[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 3.p位置新增元素
     */
    public boolean addValue(E element,int p){
        if(p < 0 || p >= this.data.length){
            throw new IllegalArgumentException("p value is error");
        }
        if(p >= this.size){
            data[p] = element;
            this.size++;
        }else{
            // 0 ~ p ~ size-1
            for (int i = size; i > p; i--) {
                this.data[i] = this.data[i-1];
            }
            this.data[p] = element;
            this.size++;
        }
        return true;
    }

    /**
     * 新增元素
     * @param element
     * @return
     */
    public boolean add(E element){
        if(this.size < this.data.length){
            this.data[size++] = element;
        }else{
            //扩容
        }
        return true;
    }

    /**
     * 5.p位置删除元素
     */
    public boolean deleteValue(E element){
        int p = getPosition(element);
        if(p > 0){
            // 0 ~ p ~ size-1
            for (int i = p; i < this.size - 1; i++) {
                this.data[i] = this.data[i + 1];
            }
            this.size--;
            return true;
        }
        return false;
    }

    public void print(){
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.data[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayListSelf<Integer> listSelf = new ArrayListSelf<>(12);
        listSelf.add(1);
        listSelf.add(3);
        listSelf.add(7);
        listSelf.add(9);
        listSelf.print();

        listSelf.addValue(5,2);
        listSelf.print();

        listSelf.deleteValue(7);
        listSelf.print();

    }
}
