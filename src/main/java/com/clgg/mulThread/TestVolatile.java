package com.clgg.mulThread;

/**
 * Created by sunshihui on 2019/9/6.
 * volatile关键字：当多个线程操作共享数据时，可以保证内存中的数据可见
 * 相较于synchronized是一种轻量级的同步策略
 *
 * 注意：
 * 1.volatile 不具备互斥性
 * 2.不能保证变量的原子性
 *
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        while (true) {
            if (td.isFlag()) {
                System.out.println("----------------");
                break;
            }
        }
    }


}


class ThreadDemo implements Runnable{


    private volatile boolean flag = false;


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;
        System.out.println("flag="+flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
