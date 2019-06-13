/**
 * $Id: luojun.java,v 1.0 2019/6/13 15:43 dell Exp $
 * <p>
 * Copyright 2018 Beijing Ultrapower Software Of Shanghai Co.Ltd
 */
package com.example.linkedlist;

import java.util.Scanner;

/**
 * @author luojun
 * @version $Id: LRUBaselinkedList.java,v 1.1 2019/6/13 15:43 luojun Exp $
 * Created on 2019/6/13 15:43
 */
public class LRUBaselinkedList<T> {
    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    /**
     * 有参构造函数
     * @param headNode
     * @param length
     * @param capacity
     */
    public LRUBaselinkedList(SNode<T> headNode, Integer length, Integer capacity) {
        this.headNode = headNode;
        this.length = length;
        this.capacity = capacity;
    }

    public LRUBaselinkedList() {
        this.headNode = new SNode<>();
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public void add(T data){

    }
    public class SNode<T>{
        private T element;
        private SNode next;
        public SNode(T element){
            this.element = element;
        }
        public  SNode(T element,SNode next){
            this.element = element;
            this.next = next;
        }
        public SNode(){
            this.next = null;
        }
        public T getElement(){
            return  element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public void printAll(){
        SNode node = headNode.getNext();
        while(node != null){
            System.out.println(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args){
        LRUBaselinkedList<Object> list = new LRUBaselinkedList();
        Scanner sc = new Scanner(System.in);
        while (true){
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}