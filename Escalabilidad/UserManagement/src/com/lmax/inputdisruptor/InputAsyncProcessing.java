package com.lmax.inputdisruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.utils.CircularQueueManager;

public class InputAsyncProcessing {
	
	private CircularQueueManager inputQueue;
	
    public CircularQueueManager getTaskQueue() {
        return inputQueue;
    }

    public void setEventQueue(CircularQueueManager inputQueue) {
        this.inputQueue = inputQueue;
    }

    public void createThreadPool() {

        ExecutorService ex = Executors.newFixedThreadPool(100);
        InputAsyncThread t;
        for (int i = 0; i < 100; i++) {
            t = new InputAsyncThread();
            t.setEventQueue(inputQueue);
            ex.execute(t);
        }
        ex.shutdown();
    }
}
