package com.lmax.inputdisruptor;

import java.util.ArrayList;

import com.lmax.businesslogicprocessor.QueryPatritioner;
import com.lmax.outputdisruptor.OutputDisruptor;
import com.lmax.vo.LmaxEvent;

public class Replicator {
	public static void replicateEvent(LmaxEvent event)
	{
		ArrayList<Object> partitionedEventResultList = QueryPatritioner.partitionEvent(event);
		for(int i= 0; i< partitionedEventResultList.size();i++)
			OutputDisruptor.recieveEventResult(partitionedEventResultList.get(i));
	}
}
