package com.lmax.outputdisruptor;

import com.lmax.outputdisruptor.OutputAsyncProcessing;
import com.lmax.utils.CircularQueueManager;

public class OutputDisruptor {
	
	private static CircularQueueManager outputQueue;
	private static OutputAsyncProcessing asyncProcessing = null;
	
	public static void startProcessing()
	{
		outputQueue = new CircularQueueManager();
		asyncProcessing =  new OutputAsyncProcessing();
		asyncProcessing.setEventQueue(outputQueue);
		asyncProcessing.createThreadPool();
	}
	
	public static void recieveEventResult(Object eventResult)
	{
		OutputReciever.recieveEventResult(outputQueue, eventResult);
	}
}
