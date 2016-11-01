package com.lmax.outputdisruptor;

import com.lmax.utils.CircularQueueManager;

public class OutputReciever {
	public static CircularQueueManager recieveEventResult(CircularQueueManager outputQueue, Object eventResult)
	{	
		outputQueue.addEvent(eventResult);
		return outputQueue;
	}
}
