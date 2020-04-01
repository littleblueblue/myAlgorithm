package com.example.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SortTestHelper {
    private SortTestHelper(){}
    /**
     * 数组是否有序
     */
    public static boolean isSorted(Comparable[] arr){
        for(int i=0;i<arr.length;i++)
            if (arr[i].compareTo(arr[i+1]) < 0)
                return true;
        return false;
    }

    /**
     * 生成一个数组数量为n 且 元素大小 在 [rangeL，rangeR）之间的 随机数组
     */
    public static Integer[] randomArray(int n,int rangeL,int rangeR){

        /** assert 是Java的关键字 如果后面的程序 为真代码继续执行，为假则检查报错，一般调试用，发布不会用，
         *  jvm自动关闭了这个功能，需要手动开启*/
        assert rangeL<=rangeR;
        int flag = rangeR-rangeL;
        Integer[] arr = new Integer[n];
        if (flag>=0){
            for (int i=0;i<arr.length;i++){
                /** Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
                 公式：Math.random()*(n-m)+m，生成大于等于m小于n的随机数；*/
                arr[i] =  new Integer((int)(Math.random()*(rangeR - rangeL) + rangeL));
            }
        }
        return arr;
    }

    /**
     * 打印数组内容
     */
    public static void printArray(Integer[] arr){
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    /**
     * 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
     */
    public static void testSort(String className,Comparable[] arr){
        try {
            /** 此处用的Java 反射 */
            Class sortClass = Class.forName(className);
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            Object[] param = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null,param);
            long endTime = System.currentTimeMillis();
            assert isSorted(arr);
            System.out.println(sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
