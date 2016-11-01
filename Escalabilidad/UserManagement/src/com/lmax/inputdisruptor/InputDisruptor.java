package com.lmax.inputdisruptor;

import com.lmax.utils.CircularQueueManager;

public class InputDisruptor {
	
	private static CircularQueueManager inputQueue;
	private static InputAsyncProcessing asyncProcessing = null;
	
	public static void startProcessing()
	{
		inputQueue = new CircularQueueManager();
		asyncProcessing =  new InputAsyncProcessing();
		asyncProcessing.setEventQueue(inputQueue);
		asyncProcessing.createThreadPool();
	}
	
	public static void recieveEvent(String idList)
	{
		InputReciever.recieveEvent(inputQueue, idList);
	}
}
