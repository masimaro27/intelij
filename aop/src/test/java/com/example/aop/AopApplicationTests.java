package com.example.aop;

import com.example.aop.service.FutureService;
import com.example.aop.service.TestService;
import com.example.aop.vo.Child;
import com.example.aop.vo.Human;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AopApplicationTests {

    @Autowired
    private TestService testService;

    @Autowired
    private FutureService futureService;

    @Test
    void contextLoads() {
    }

    @Test
    void annotationAopTest() throws InterruptedException {

        Child c1 = new Child("minc", 1);
        Child c2 = new Child("minc", 2);
        Child c3 = new Child("minc", 3);
        new Human ();
        List<Child> childs = Arrays.asList(c1,c2,c3);
        testService.serve("test", 1, new Human("min", 32, c1, childs));
    }

    @Test
    void asyncAopTest() throws ExecutionException, InterruptedException {
        futureService.asyncService();
    }

}
