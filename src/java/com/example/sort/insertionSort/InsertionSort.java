package com.example.sort.insertionSort;

import com.example.sort.SortTestHelper;

import java.util.Arrays;

/**
 * 插入排序：
 * 第一步、第二个元素开始，与第一个元素作比较，如果啊arr[2]<arr[1] 则交换
 * 第二步、第三个元素开始，与前两个元素两两作比较，找到合适的位置插入
 * ...
 */
public class InsertionSort {
    public InsertionSort(){}

    public static void sort(Comparable[] arr){
        /** 该方法是自己写的 */
//        for (int i=0;i<arr.length;i++)
//            for(int j=1;j<arr.length;j++)
//                if (arr[j].compareTo(arr[j-1])<0)
//                    swap(arr,j,j-1);

        /** 方法1 */
//        for (int i=0;i<arr.length;i++)
//            for(int j = i; j > 0; j--)
//                if(arr[j].compareTo(arr[j-1])< 0){
//                    swap(arr,j,j-1);
//                }else{
//                    break;
//                }

        /** 方法2 */
//        for (int i=0;i<arr.length;i++)
//            for(int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--)
//                swap(arr,j,j-1);

        /**
         * 方法3:插入排序的改进方法
         * 每一个元素寻找合适的位置插入，就要交换一次，三次赋值移动数组，很浪费时间
         * 改成一次赋值
         */
        for (int i=0;i<arr.length;i++){
            Comparable value = arr[i];
            int j=i;
            for (;j>0 && arr[j-1].compareTo(value)>0;j--)
                arr[j] = arr[j-1];
            arr[j] = value;
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
         Comparable temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
    }

    public static void main(String[] args) {
        int n=2000;
        Integer[] arr1 = SortTestHelper.randomArray(n, 1, 2000);
        SortTestHelper.testSort("com.example.sort.insertionSort.InsertionSort",arr1);
        SortTestHelper.printArray(arr1);   //45ms

        // 比较SelectionSort和InsertionSort两种排序算法的性能效率
        // 此时，插入排序比选择排序性能略低
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
        SortTestHelper.testSort("com.example.sort.selectionSort.SelectionSort",arr2);
        SortTestHelper.printArray(arr2);  //20ms

    }

}
