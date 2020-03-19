package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloader extends Thread {

    Semaphore semaphore;
    CountDownLatch CDL;
    private int file;
    private int downloadSpeed;

    public Downloader(Semaphore semaphore, CountDownLatch CDL, int file, int downloadSpeed) {
        this.semaphore = semaphore;
        this.CDL = CDL;
        this.file = file;
        this.downloadSpeed = downloadSpeed;
    }

    public int getFile() {
        return file;
    }

    public int getDownloadSpeed() {
        return downloadSpeed;
    }

    public void run() {
        try {

            System.out.println("Файл скачивается ");

            for (int i = 0; i < getFile(); i += getDownloadSpeed()) {
                Thread.sleep(100);
            }

            System.out.println("Загрузка завершена ");

        } catch (InterruptedException IE) {
            System.out.println("Проверьте подключение ");
        }
    }
}