package config;


import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


import java.util.concurrent.Executor;


@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {


    private static final int CORE_POOL_SIZE = 5;

    private static final int MAX_POOL_SIZE = 20;

    private static final int QUEUE_CAPACITY = 500;


    @Bean(name = "platformTaskExecutor")
    public Executor taskExecutor() {


        ThreadPoolTaskExecutor executor =
                new ThreadPoolTaskExecutor();


        executor.setCorePoolSize(
                CORE_POOL_SIZE
        );


        executor.setMaxPoolSize(
                MAX_POOL_SIZE
        );


        executor.setQueueCapacity(
                QUEUE_CAPACITY
        );


        executor.setThreadNamePrefix(
                "platform-async-"
        );


        executor.initialize();


        return executor;

    }



    @Override
    public Executor getAsyncExecutor() {

        return taskExecutor();

    }



    @Override
    public AsyncUncaughtExceptionHandler
    getAsyncUncaughtExceptionHandler() {


        return (throwable, method, params) -> {


            System.err.println(
                    "Async Error in method : "
                            + method.getName()
            );


            throwable.printStackTrace();

        };

    }

}
