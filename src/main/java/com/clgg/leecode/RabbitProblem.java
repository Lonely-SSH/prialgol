package com.clgg.leecode;

/**
 * Created by sunshihui on 2019/7/24.
 */
public class RabbitProblem {
    public static void main(String[] args) {
        /*
        古典问题：
        有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
        假如兔子都不死，问每个月的兔子总数为多少？
        这是一个菲波拉契数列问题

        我们假定第一个月的兔子为小兔子，第二个月为中兔子，第三个月之后就为大兔子

            1   1、0、0
            2   0、1、0
            3   1、0、1
            4   1、1、1
            5   2、1、2
            6   3、2、3
            7   5、3、5

         兔子总数分别为：1、1、2、3、5、8、13……

         于是得出了一个规律，从第三个月起，后面的兔子总数都等于前面两个月的兔子总数之和，即为斐波那契数列。
         */

        for (int i = 1; i <= 12 ; i++) {
            System.out.println("兔子第"+i+"个月的数量为："+(2*f(i))+"只");
        }

//        1 1 2 3 5 8 13

    }


    public static int f(int x) {
        if (x == 1 || x == 2) {
            return 1;

        } else {
            return f(x - 1) + f(x - 2);
        }
    }
}
