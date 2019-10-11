package com.clgg.mulThread;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by sunshihui on 2019/9/10.
 * 写入并复制
 * 添加多时候，不适合使用；迭代多时，适合使用
 */
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        for (int i = 0; i <10 ; i++) {
            new Thread(helloThread).start();
        }
    }
}

class HelloThread implements Runnable{
//    private  static List<String> list = Collections.synchronizedList(new ArrayList<String>());
    private  static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();

    static{
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
    }
    @Override
    public void run() {
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

            list.add("SUN");
        }
    }
}

