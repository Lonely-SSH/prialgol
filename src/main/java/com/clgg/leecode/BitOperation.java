package com.clgg.leecode;

/**
 * Created by sunshihui on 2019/8/13.
 */
public class BitOperation {
    public static void main(String[] args) {
        //位运算的技巧

        //1 、判断奇数
        System.out.println("=====判断奇数======");
        int n = 13;
        // 奇数
        if (n % 2 == 1) {
            System.out.println("是个奇数：" + n);
        }

        /*
         * 把n用二进制转换的话，只需要判断二级制的最后一位是0 or 1
         *
         */
        if ((n & 1) == 1) {
            System.out.println("是个奇数：" + n);
        }


        //2、交换两个数
        //low
        System.out.println("====交换两个数=====");
        int x = 1, y =2;
        int temp = x;
        x = y;
        y = temp;
        System.out.println(x);
        System.out.println(y);

        //高级方法(异或)
        System.out.println("====高级方法====");
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println(x);
        System.out.println(y);


        // 3、 找出没有重复的数
        System.out.println("==找出没有重复的数==");
        /*数组中只有一个数出现一次，剩余数都出现两次，找出出现一次的数*/
        int[] arr = new int[] {1,2,3,4,5,1,2,3,4};
        System.out.println(find(arr));
        /*
         *  就限于两个数相同 ^ 等于1
         *  ^ 支持交换和结合 所以 1^2^3^4^5^1^2^3^4 = (1^1)^(2^2)^(3^3)^(4^4)^5
        */

        // 4、m 的 n 次方
        System.out.println("==m 的 n 次方 M1 ==");
        System.out.println(pow1(3));

        System.out.println("==m 的 n 次方 M2 ==");
        System.out.println(pow2(3));

        // 5、找出不大于N的最大的2的幂指数
        /*传统方法*/
        System.out.println("==找出不大于N的最大的2的幂指数 ==");
        System.out.println(findN(6));

        System.out.println(findN2(6));
    }

    //找出没有重复的数
    public static int find(int[] arr) {
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tmp = tmp ^ arr[i];
        }
        return tmp;
    }

    //m 的 n 次方   M1 -- low
    public static int pow1(int n) {
        int tmp = 1;
        for(int i = 1; i <= n; i++) {
            // m = 2
            tmp = tmp * 2;
        }
        return tmp;
    }
    //m 的 n 次方   M2
    public static int pow2(int n) {
        int sum = 1;
        // m = 2
        int tmp = 2;
        while(n != 0) {
            if((n & 1) == 1) {
                sum *= tmp;
            }
            tmp *= tmp;
            n = n >> 1;
        }
        return sum;
    }
    //找出不大于N的最大的2的幂指数
    public static int findN(int n) {
        int sum = 1;
        while(true) {
            if(sum * 2 > n) {
                return sum;
            }
            sum *= 2;
        }
    }

    public static int findN2(int n) {
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;

        return (n + 1) >> 1;
    }
}
