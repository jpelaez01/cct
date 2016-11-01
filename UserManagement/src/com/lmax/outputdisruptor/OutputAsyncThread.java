package com.lmax.outputdisruptor;

import com.lmax.utils.CircularQueueManager;
import com.lmax.vo.LmaxEvent;

public class OutputAsyncThread extends Thread {

    private CircularQueueManager outputQueue;

    public CircularQueueManager getEventQueue() {
        return outputQueue;
    }

    public void setEventQueue(CircularQueueManager outputQueue) {
        this.outputQueue = outputQueue;
    }

    public OutputAsyncThread() {
    	
    }

    public void run() {

    	Object eventResult = null;
        while (true) {

            try {
                //System.out.println("Async Thread running...");
                if(outputQueue != null)
                {
                	eventResult = (LmaxEvent) outputQueue.getEvent();
                	if(eventResult != null)
                		execute(eventResult);
                }
                else
                {
                	Thread.sleep(100);
                }
            } catch (Exception e) {

                System.out.println("Exception on output thread, please contact system admin!");
            }
        }
    }
    
    public void execute(Object eventResult){
    	Object newEventResult = Marshaller.marshallEvent(eventResult);
    	Publisher.publishEvent(newEventResult);
	 }
}
