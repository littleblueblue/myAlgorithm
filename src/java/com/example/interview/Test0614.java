/**
 * $Id: zhoulan.java,v 1.0 2019/6/14 14:37 dell Exp $
 * <p>
 * Copyright 2018 Beijing Ultrapower Software Of Shanghai Co.Ltd
 */
package com.example.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoulan
 * @version $Id: Test0614.java,v 1.1 2019/6/14 14:37 zhoulan Exp $
 * Created on 2019/6/14 14:37
 * 面试题 2019-06-14
 * 1、Relative Pay: （相对工资）
 *   Each row should contain a pair of names;the NAME of a lower earning employee and the NAME of a higher earning employee.
 *   Sort first by the lower earning employee's ID ,then by the higher earning employee's SALARY.
 * 2、Counting Bits: （计数位）
 *   How many 1-bites are in its binary representation?
 *   The number n's binary representation has k significant bits indexed from 1 to k. What are the respective positions of each 1-bit,in ascending order?
 *   eg. 37     100101       [3146]
 * 3、Simple Text Queries: （简单文本查询）
 *   textQueries has the following parameter(s):
 *       sentences[sentences[0],...,sentences[n-1]]: an array of sentence strings consisting of space-separated words.
 *       queries[queries[0],...,queries[q-1]]: an array of query phrases consisting of space-separated words.
 * 4、IP Address Validation: （IP地址验证）
 *   validateAddress has the following parameter(s):
 *       addresses[addresses[0],...,addresses[n-1]]: an array of strings.
 * 5、Git:Rebase/Merge:（Git：重新组合/合并）
 */
public class Test0614 {

    /**
     * Counting Bits: （计数位）
     */
    public  int countNumber1(int n){
        int count;
        for (count = 0; n > 0; ++count) {
            n &= (n - 1);
        }
        return count;
    }
    public  String countNumber2(int n) {
        String result = "";
        boolean minus = false;

        //如果该数字为负数，那么进行该负数+1之后的绝对值的二进制码的对应位取反，然后将它保存在result结果中
        if (n < 0) {
            minus = true;
            n = Math.abs(n + 1);
        }
        while (true) {
            int remainder = (!minus && n % 2 == 0) || (minus && n % 2 == 1) ? 0 : 1;

            //将余数保存在结果中
            result = remainder + result;
            n /= 2;

            if (n == 0) {
                break;
            }
        }

        //判断是否为负数，如果是负数，那么前面所有位补1
        if (minus) {
            n = result.length();
            for (int i = 1; i <= 32 - n; i++) {
                result = 1 + result;
            }
        }

        System.out.println(result);
        return result;
    }

    @Test
    public  void test01() {
//        String str = Integer.toBinaryString(161);
//        char[] chars = str.toCharArray();
        List list = new ArrayList<>();
        int count = countNumber1(161);
        list.add(count);
        char[] chars = countNumber2(161).toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (chars[i]==49){
                list.add(i+1);
            }
        }
        System.out.println(list);
    }

    @Test
    public void test(){
        String str = "tenantCode_abilityCode_1000";
        str.lastIndexOf(-1);
        String[] strArr = str.split("\\_");
        String codeNumber = strArr[2];

        int maxBizCode= Integer.parseInt(codeNumber);
        maxBizCode = maxBizCode + 1;
        str=String.format("%03d",maxBizCode);
        System.out.println(str);
    }
}