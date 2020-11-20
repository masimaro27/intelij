package com.example.threadsafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyCounter {

    private int count;

    public void increment() {
        int temp = count;
        count = temp + 1;
        log.info("{}", count);
    }

    public void incrementWithWait() throws InterruptedException {
        int temp = count;
        wait(100);
        count = temp + 1;
        log.info("{}", count);
    }

    public int getCount() {
        return count;
    }

}