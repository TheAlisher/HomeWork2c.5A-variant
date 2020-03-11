package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloader extends Uploader {

    Semaphore semaphore;
    CountDownLatch CDL;

    public Downloader(int file, int downloadSpeed, Semaphore semaphore, CountDownLatch CDL) {
        super(file, downloadSpeed);
        this.semaphore = semaphore;
        this.CDL = CDL;
    }
}