package com.example.sort.selectionSort;

import com.example.sort.SortTestHelper;
import com.example.sort.Student;
import org.junit.Test;

/**
 * 选择排序：外循环从第一个开始，内循环再从剩下的里面一一比较找到最小的最后与第一个进行比较
 */
public class SelectionSort {
    /** 在Junit测试类中必须声明一个public 构造函数 */
    public SelectionSort(){}

    /**
     * int 数组
     * @param arr
     * @return
     */
    public int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[i]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);//这一步放在内循环体外，找到最小的再交换位置
        }
        return arr;
    }

    public void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printIntAll(int[] arr){
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    @Test
    public void testSort() {
        int[] arr={2,4,7,1,2,3,8};
        printIntAll(sort(arr));
    }

    /**
     * Use Comparable
     * @param arr
     */
    public Comparable[] sortUseComparable(Comparable[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex = i;
            for(int j = i+1;j<arr.length;j++){
                if (arr[j].compareTo(arr[minIndex]) < 0){ //注意内循环一次，每次要与拿到的最新的最小值作比较
                    minIndex = j;
                }
            }
            swapUseComparable(arr,i,minIndex);
        }
        return arr;
    }

    public void swapUseComparable(Comparable[] arr,int i,int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void testSortUseComparable() {
        //测试Integer
//        Integer[] a = {10,9,8,7,6,5,7,3,2,1};
        Integer[] a = {10,17,17,9,18,6,2,6,11,10};

        sortUseComparable(a);
        for( int i = 0 ; i < a.length ; i ++ ){
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();

        //测试Double
        Double[] b = {6.6, 2.2, 2.2, 1.1};
        sortUseComparable(b);
        for( int i = 0 ; i < b.length ; i ++ ){
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();

        //测试String
        String[] c = {"D", "C", "B", "A"};
        sortUseComparable(c);
        for( int i = 0 ; i < c.length ; i ++ ){
            System.out.print(c[i]);
            System.out.print(' ');
        }
        System.out.println();

        //测试自定义的类 Student
        Student[] stu = new Student[4];
        stu[0] = new Student("D",90);
        stu[1] = new Student("C",100);
        stu[2] = new Student("B",95);
        stu[3] = new Student("A",95);
        sortUseComparable(stu);
        for( int i = 0 ; i < stu.length ; i ++ )
            System.out.println(stu[i]);
    }

    /**
     * random Array
     * @param arr
     */
    public Integer[] randomArray(int n,int rangeL,int rangeR){

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
    public void printRandomArray(Integer[] arr){
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    @Test
    public void testRandomArray(){
        Integer[] arr = randomArray(10, 1, 20);
        printRandomArray(arr);
    }

    @Test
    public void testSortRandomArray(){
        int n=10;
        Integer[] arr = randomArray(n, 1, 20);
        sortUseComparable(arr);
        printRandomArray(arr);
    }

    /**
     * 测试排序辅助函数，测试算法性能
     * 因为@Test JUnit不支持传参所以以下重写一个sort方法，static main函数调用
     * */
    public static void swap(Comparable[] arr,int i,int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort(Comparable[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex = i;
            for(int j = i+1;j<arr.length;j++){
                if (arr[j].compareTo(arr[minIndex]) < 0){ //注意内循环一次，每次要与拿到的最新的最小值作比较
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }
    public static void main(String[] args) {
        int n=10;
        Integer[] arr = SortTestHelper.randomArray(n, 1, 20);
        SortTestHelper.testSort("com.example.sort.selectionSort.SelectionSort",arr);
        SortTestHelper.printArray(arr);
    }
}
