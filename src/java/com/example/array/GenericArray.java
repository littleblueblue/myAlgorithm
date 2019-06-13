/**
 * $Id: zhoulan.java,v 1.0 2019/6/8 12:48 dell Exp $
 * <p>
 * Copyright 2018 Beijing Ultrapower Software Of Shanghai Co.Ltd
 */
package com.example.array;

import java.util.Arrays;

/**
 * @author zhoulan
 * @version $Id: GenericArray.java,v 1.1 2019/6/8 12:48 zhoulan Exp $
 * Created on 2019/6/8 12:48
 */
public class GenericArray<T> {
    private T[] data;
    private int size;  //数组长度=数组大小=数组最多承载元素个数

    //根据传入容量，构造Array
    public GenericArray(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    //无参构造方法，默认数组容量为10
    public GenericArray(){
        this(10);
    }

    //获取数组容量
    public int getCapacity(){
        return data.length;
    }

    //获取当前元素个数
    public int count(){
        return size;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //修改index位置的元素
    public T get(int index){
        checkIndex(index);
        return data[index];
    }

    //查看数组是否包含元素e
    public boolean contains(T e){
        for(int i = 0; i < size; i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    public int findIndex(T e){
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    // a b x c d e
    // 0 1 2 3 4
    public void add(int index,T e){
        checkIndex(index);
        // 如果当前元素个数等于数组容量，则将数组扩容为原来的2倍
        if (data.length == size){
            //数组空间已满
            resize(2 * data.length);
        }
        for (int i = size -1; i > index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //向数组头插入元素
    public void addFirst(T e){
        add(0,e);
    }

    // 向数组尾插入元素
    public void addLast(T e) {
        add(size, e);
    }

    // 删除 index 位置的元素，并返回
    public T remove(int index){
        checkIndexForRemove(index);
        T ret = data[index];
        for (int i = index + 1; i < size; i++){
            data[i-1] = data[i];
        }
        size --;
//        return data[index];
        data[size] = null;

        //缩容
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    //删除第一个元素
    public T removeFirst(){
        return remove(0);
    }

    //删除最后一个元素
    public T removeLast(){
        return remove(data.length-1); // size-1
    }

    //从数组中删除指定元素
    public void removeElement(T e){
        int index = findIndex(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++){
            builder.append(data[i]);
            if (i != size -1){
                builder.append(",");
            }
        }
        builder.append(']');
        return builder.toString();
//        return "GenericArray{" +
//                "data=" + Arrays.toString(data) +
//                ", size=" + size +
//                '}';
    }

    //扩容方法,时间复杂度O(n)
    //重新申请一个新的内存空间，然后把原来内存里的数组全部拷贝到新的内存中去
    private void resize(int capacity){
        T[] newData = (T[]) new Object[capacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }

    }

    private void checkIndexForRemove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
        }

    }
}