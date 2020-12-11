package com.summerli;

public class InterruptTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1开始循环");
            while(true){
                if(Thread.interrupted()){
                    System.out.println(Thread.currentThread().getName()+"被打断了");
                }
            }
        }, "t1");

        Thread t2 = new Thread(()->{
            try {
                System.out.println("t2开始睡觉");
                Thread.sleep(3000);
                t1.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
