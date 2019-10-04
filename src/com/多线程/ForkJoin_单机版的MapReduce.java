package com.多线程;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin_单机版的MapReduce {
    
    public static void main(String[] args) {
        // fork就是异步的执行一个任务，join就是阻塞当前线程等待子任务的执行结果
        String[] lines = {"hello world",  "hello fork", "hello join", "fork join", "fork join in world",}; 
        WordCountMR mr = new WordCountMR(lines, 0, lines.length);
        ForkJoinPool pool = new ForkJoinPool(2);          //构造函数传的是CPU数
        Map<String, Long> result = pool.invoke(mr);
        result.forEach((k, v) -> {System.out.println(k + ":" + v);});
    }
   
}

class WordCountMR extends RecursiveTask<Map<String, Long>> {
    
    private static final long serialVersionUID = 1L;
    private String[] fc;
    private int start, end;

    WordCountMR(String[] fc, int start, int end) {
        this.fc = fc;
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected Map<String, Long> compute() {
        if(end - start <= 1) {
            return calc(fc[start]);
        } else {
            // 分治法
            int mid = (start+end)/2;
            WordCountMR mr1 = new WordCountMR(fc, start, mid);
            mr1.fork();
            WordCountMR mr2 = new WordCountMR(fc, mid, end);
            mr2.fork();
            
            // 结果合并
            return merge(mr2.compute(), mr1.join());
            
        }

    }
    
    /**
     * 结果合并
     * @param result1
     * @param result2
     * @return
     */
    private  Map<String, Long> merge(Map<String, Long> result1, Map<String, Long> result2){
        Map<String, Long> result = new HashMap<>();
        result.putAll(result1);
        result2.forEach((word, result2Count)->{
            Long result1Count = result.get(word);
            if(result1Count == null) {
                result.put(word, result2Count);
            } else {
                result.put(word, result1Count+result2Count);
            }
        });
        return result;
    }
    
    /**
     * 单词统计
     * @param line
     * @return
     */
    private Map<String, Long> calc(String line) {
        Map<String, Long> result = new HashMap<>();
        
        // 单词统计
        String[] words = line.split("\\s+");
        for(String word : words) {
            Long count = result.get(word);
            if(count == null) {
                result.put(word, 1L);
            } else {
                result.put(word, count+1);
            }
        }
        return result;
    }
    
    
    
    
    
    
    
    
}