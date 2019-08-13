package com.clgg.leecode;

/**
 * Created by sunshihui on 2019/8/13.
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;

        System.out.println("原始**************棋盘");
        for(int[] arr1 : arr){
            for(int arr2 :arr1){
                System.out.printf("%d\t",arr2);
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length ; j++) {
                if(arr[i][j] != 0){
                    sum++;
                }
            }
        }

        System.out.println("不为0的值的个数："+sum);

        int[][] newArr = new int[sum+1][3];
        newArr[0][0]=arr.length;
        newArr[0][1]=arr.length;
        newArr[0][2]=sum;

        int count = 0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length ; j++) {
                if(arr[i][j] != 0){
                    count++;
                    newArr[count][0] = i;
                    newArr[count][1] = j;
                    newArr[count][2] = arr[i][j];
                }
            }
        }


        System.out.println("转换后**************棋盘");
        for(int[] arr7 : newArr){
            for(int arr8 :arr7){
                System.out.printf("%d\t",arr8);
            }
            System.out.println();
        }




    }


}
