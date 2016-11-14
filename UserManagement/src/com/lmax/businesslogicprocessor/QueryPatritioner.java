package com.lmax.businesslogicprocessor;

import java.util.ArrayList;
import com.lmax.vo.LmaxEvent;

public class QueryPatritioner {
	
	public static ArrayList<Object> partitionEvent(LmaxEvent event) throws Exception
	{
		ArrayList<Object> eventList =  new ArrayList<Object>();
		ArrayList<Integer> idList = event.getIdList();
		for(int i= 0; i < idList.size(); i++)
		{
			int id = idList.get(i);
			//Call merge with id
			eventList.add(id);			
		}
		return eventList;
	}
	
	public static ArrayList<Object> joinEvent(LmaxEvent[] events) throws Exception
	{
		ArrayList<Object> eventList =  new ArrayList<Object>();
		for(int i= 0; i < events.length; i++)
		{
			Object eventResult = events[i];
			//Call merge with id
			eventList.add(eventResult);			
		}
		return eventList;
	}
}
