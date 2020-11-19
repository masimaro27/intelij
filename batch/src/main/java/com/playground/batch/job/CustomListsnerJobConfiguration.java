package com.playground.batch.job;

import com.playground.batch.job.listener.SkipCheckingListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
/**
 * TODO: Listener 로그 확인 안됨.
 */
public class CustomListsnerJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job customListenerJob() {
        return jobBuilderFactory.get("customListenerJob")
//                .listener(new SkipCheckingListener())
                .start(customListsnerStep1())
                    .on("FAILED")
                .end()
                .from(customListsnerStep1())
                    .on("COMPLETED WITH SKIPS")
                    .to(errorPrint1())
                .from(customListsnerStep1())
                    .on("*")
                    .to(customListsnerStep2())
                .end()
                .build();
    }

    @Bean
    public Step customListsnerStep1() {
        return stepBuilderFactory.get("customListsnerStep1")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>> This is stepNextConditionalJob Step1");

                    /**
                     ExitStatus를 FAILED로 지정한다.
                     해당 status를 보고 flow가 진행된다.
                     **/
                    contribution.setExitStatus(ExitStatus.COMPLETED);

                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step customListsnerStep2() {
        return stepBuilderFactory.get("customListsnerStep2")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>> This is stepNextConditionalJob Step2");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step customListsnerStep3() {
        return stepBuilderFactory.get("customListsnerStep3")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>> This is stepNextConditionalJob Step3");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step errorPrint1 () {
        return stepBuilderFactory.get("ErrorPrintStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>> errorPrint1");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}

