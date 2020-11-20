package com.example.threadsafe;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

class ThreadsafeApplicationTests {

    @Rule
    public ConcurrentRule concurrently = new ConcurrentRule();
    @Rule
    public RepeatingRule rule = new RepeatingRule();

    private static MyCounter counter1 = new MyCounter();
    private static final AtomicInteger counter = new AtomicInteger();


    @Test
    @Concurrent(count = 5)
    @Repeating(repetition = 10)
    public void runsMultipleTimes() {
        counter.getAndIncrement();
    }

    @After
    public static void annotatedTestRunsMultipleTimes() throws InterruptedException {
        System.out.println("counter : " + counter);
        assertEquals(counter, 20);
    }

}
