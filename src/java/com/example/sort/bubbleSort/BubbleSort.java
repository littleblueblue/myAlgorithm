package com.example.sort.bubbleSort;

import com.example.sort.SortTestHelper;

import java.util.Arrays;

public class BubbleSort {
    public BubbleSort() {}

    public static void sort(Comparable[] arr) {
        /** 该方法是自己写的 */
//        int n = arr.length;
//        for (int i=0; i< n; i++){
//            for(int j=0; j<n-1; j++){
//                if (arr[j].compareTo(arr[j+1])>0)
//                    swap(arr,j,j+1);
//            }
//        }
        /** 方法1：优化 */
//        int n = arr.length;
//        boolean swapped = false;
//        do {
//            swapped = false;
//            for (int i=0; i<n-1;i++){
//                if (arr[i].compareTo(arr[i+1]) > 0)
//                    swap(arr,i,i+1);
//                swapped = true;
//            }
//            // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
//            // 所以下一次排序, 最后的元素可以不再考虑
//            length--;
//        }while (swapped);

        /** 方法2：优化*/
        int n = arr.length;
        int newn ; //使用newn进行优化
        do {
            newn = 0;
            for (int i=0; i<n-1; i++){
                if (arr[i].compareTo(arr[i+1])>0)
                    swap(arr,i,i+1);
                newn = i+1; //记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑

            }
            n = newn;
        }while (newn > 0);

        /**
         * 以上也可以int i=1;i<arr.length;i++ 然后比较arr[i-1] 、arr[i]
         */
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n=10;
        Integer[] arr1 = SortTestHelper.randomArray(n, 1, 10);
        SortTestHelper.testSort("com.example.sort.bubbleSort.BubbleSort",arr1);
        SortTestHelper.printArray(arr1);   //45ms
    }
}
