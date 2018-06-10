package ru.malltshik.tasks;

import java.util.BitSet;

public class BitSetQuiz {

    final static BitSet bs = new BitSet();

    static Thread t1 = new Thread(() -> {
        bs.get(1);
    });

    static Thread t2 = new Thread(() -> {
        bs.get(2);
    });

    static Thread t3 = new Thread(() -> {
        System.out.println(bs.get(1));
        System.out.println(bs.get(2));
    });

    public static void main(String[] args) throws InterruptedException {
        t3.join();
        t1.start();
        t2.start();
        t3.start();
    }

}
