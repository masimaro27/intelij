package com.example.threadsafe;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import org.junit.After;
import org.junit.Rule;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class RunConcurrentlyTest {

    @Rule
    public ConcurrentRule rule = new ConcurrentRule();

    private static final AtomicInteger counter = new AtomicInteger();

    @Test
    @Concurrent(count = 5)
    public void runsMultipleTimes() {
        counter.getAndIncrement();
    }

    @After
    public void test() {
    }

}
