package com.company;
/**
 * ALISHER
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Uploader uploader = new Uploader(500, 20);
        uploader.start();

        try {
            uploader.join();
            for (int i = 1; i < 10; i++) {
                Semaphore semaphore = new Semaphore(3,true);
                CountDownLatch CDL = new CountDownLatch(10);
                new Downloader(500,100, semaphore, CDL).start();
            }

        } catch (InterruptedException IE) { }
    }
}
