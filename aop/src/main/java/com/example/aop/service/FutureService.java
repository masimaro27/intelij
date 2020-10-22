package com.example.aop.service;

import com.example.aop.annotation.LogExecutionTime;
import com.example.aop.vo.Child;
import com.example.aop.vo.Human;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class FutureService {

    @LogExecutionTime
    public Child asyncService() throws ExecutionException, InterruptedException {
        CompletableFuture<Child> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("sleep");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new Child("test", 2);
        }).thenCompose((child) -> CompletableFuture.supplyAsync(() -> {
          return child;
        }));

        return future.get();
    }
}
