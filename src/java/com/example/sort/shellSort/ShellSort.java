package com.example.sort.shellSort;

import com.example.sort.SortTestHelper;

import java.util.Arrays;

/**
 * 希尔排序，实质上是一种分组插入方法
 * 算法思想：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分组，所有距离为d1的倍数的记录放在同一个组中
 * 先在各组内进行直接插入排序；然后取第二个增量d2<d1重复上述的分组和排序，直至所取的增量d1=1,即所有记录放在同一组中进行直接插入排序为止
 * 一般的初次取序列的一半为增量，以后每次减半，直到增量为1
 */
public class ShellSort {
    public ShellSort(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        int d = 1;
        while (d < n/2)
            d = 2*d+1;

        while(d>=1){
            for (int i=d;i<n;i++){
                Comparable value = arr[i];
                int j=i;
                for (;j>=d && arr[j-d].compareTo(value)>0;j=j-d)
                    arr[j] = arr[j-d];
                arr[j] = value;
            }
            d = d/2;
        }
    }

    public static void main(String[] args) {
        int n=2000;
        Integer[] arr1 = SortTestHelper.randomArray(n, 1, 2000);
        SortTestHelper.testSort("com.example.sort.shellSort.ShellSort",arr1);
        SortTestHelper.printArray(arr1);
    }
}
