package com.clgg.mulThread;

/**
 * Created by sunshihui on 2019/9/11.\
 * 线程池操作
 */
public class TsetThreadPool {
    public static void main(String[] args) {
//        ThreadPoolDemo demo = new ThreadPoolDemo();
//
//        //1.创建线程池
//        ExecutorService service = Executors.newFixedThreadPool(5);
//        //2.为线程池中分配任务
//        for (int i = 0; i < 10; i++) {
//            service.submit(demo);
//        }
//        //3.关闭池连接
//        service.shutdown();
            "S".equals("SSS");

//        Executors.
    }
}

class ThreadPoolDemo implements Runnable{
    private int i = 0;


    @Override
    public void run() {
        while(i<=100){
            System.out.println(Thread.currentThread().getName()+" : "+i++);
        }
    }
}