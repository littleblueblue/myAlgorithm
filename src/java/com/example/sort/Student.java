package com.example.sort;

/**
 * 自定义对象的排序需要继承Comparable<T>接口，
 * 重写compareTo方法
 */

public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name,int score){
       this.name = name;
       this.score = score;
    }

    /**
     * 如果分数不等，则按照分数高低
     * 如果分数相等，则按照名字的中午顺序
     * @param that
     * @return
     */
    @Override
    public int compareTo(Student that) {
        if (this.score < that.score){
            return -1;
        }else if(this.score > that.score){
            return 1;
        }else{
            return this.name.compareTo(that.name);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
