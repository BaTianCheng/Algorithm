package com.多线程.ext;

import java.util.concurrent.Callable;

/**
 * Future任务
 * @author wicks
 *
 */
public class CallableTask implements Callable<String> {
    private String param;
    private long sleepTime;

    public CallableTask(String param, long sleepTime) {
        this.param = param;
        this.sleepTime = sleepTime;
    }

    // 处理业务逻辑
    public String call() throws Exception {
        //利用sleep来表示任务处理
        System.out.println(System.currentTimeMillis() + ":" +param+" start.");
        Thread.sleep(sleepTime);
        System.out.println(param+"!!!");
        return param+" finish.";
    }
}

