/**
 * $Id: zhoulan.java,v 1.0 2019/6/4 14:53 dell Exp $
 * <p>
 * Copyright 2018 Beijing Ultrapower Software Of Shanghai Co.Ltd
 */
package com.example.array;

/**
 * @author zhoulan
 * @version $Id: Array.java,v 1.1 2019/6/4 14:53 zhoulan Exp $
 * Created on 2019/6/4 14:53
 */

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 */
public class Array {
    //定义整型数组data保存数据
    public int data[];
    //定义数组长度
    private int length;
    //定义实际个数
    private int count;

    //构造方法，定义数组大小
    public Array(int length){
        this.data = new int[length];
        this.length= length;
        this.count = 0; //一开始一个数都没有存所以为0
    }

    /**
     * 根据索引，找到数据中的元素返回
     * @param index
     * @return
     */
    public int find(int index){
        if(index < 0 || index >= length) return -1;
        return data[index];
    }

    /**
     * 插入元素:头部插入，尾部插入
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index,int value){

        //数组中没有元素
        if(index == count && count == 0){
            data[index] = value;
            ++count;
            return true;
        }
        //如果数组空间已满
        if(count == length){
            System.out.println("------数组空间已满");
            return false;
        }

        //如果数组空间没满
        //位置不合法
        if(index < 0 || index >= length){
            System.out.println("------数组插入元素位置不合法");
            return false;
        }

        //位置合法
        for(int i=count; index>count; --i){
            data[i] = data[i-1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    /**
     * 根据索引，删除数组中元素
     * @param index
     * @return
     */
    public boolean delete(int index){
        if(index < 0 || index >= length) return false;
        //从删除位置开始，将后面的元素向前移动一位
        for(int i=index+1;i<count;++i){
            data[i-1] = data[i];
        }
        --count;
        return true;


        //删除数组末尾元素
        /*int[] arr = new int[count-1];
        for (int i=0; i<count-1;i++){
            arr[i] = data[i];
        }
        this.data = arr;*/

    }
    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    /**
     *
     */

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.insert(3, 11);
        array.printAll();
    }
}