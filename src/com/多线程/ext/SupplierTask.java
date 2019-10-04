package com.多线程.ext;

import java.util.function.Supplier;

public class SupplierTask implements Supplier<String>{

    private String param;
    private long sleepTime;

    public SupplierTask(String param, long sleepTime) {
        this.param = param;
        this.sleepTime = sleepTime;
    }

    // 处理业务逻辑
    public String get() {
        //利用sleep来表示任务处理
        System.out.println(System.currentTimeMillis() + ":" +param+" start.");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(param+"!!!");
        return param+" finish.";
    }

}
