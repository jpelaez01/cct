package com.lmax.inputdisruptor;

import com.lmax.utils.CircularQueueManager;
import com.lmax.vo.LmaxEvent;
import com.lmax.vo.MarshalledEvent;

public class InputAsyncThread extends Thread {

    private CircularQueueManager inputQueue;

    public CircularQueueManager getEventQueue() {
        return inputQueue;
    }

    public void setEventQueue(CircularQueueManager inputQueue) {
        this.inputQueue = inputQueue;
    }

    public InputAsyncThread() {
    	
    }

    public void run() {

    	MarshalledEvent event = null;
        while (true) {

            try {
                //System.out.println("Async Thread running...");
                if(inputQueue != null)
                {
                	event = (MarshalledEvent) inputQueue.getEvent();
                	if(event != null)
                		execute(event);
                }
                else
                {
                	Thread.sleep(10);
                }
            } catch (Exception e) {

                System.out.println("Exception on input thread, please contact system admin!");
            }
        }
    }
    
    public void execute(MarshalledEvent event){
    	Journaler.logEvent(event);
		LmaxEvent newEvent = Unmarshaller.unmarshallEvent(event);
		Replicator.replicateEvent(newEvent);
	 }
}
