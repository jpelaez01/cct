package com.lmax.inputdisruptor;

import java.util.ArrayList;
import com.lmax.utils.UniqueIdGenerator;
import com.lmax.vo.LmaxEvent;
import com.lmax.vo.MarshalledEvent;

public class Unmarshaller {
	
	public static LmaxEvent unmarshallEvent(MarshalledEvent event)
	{
		int newId = UniqueIdGenerator.getNewId();
		ArrayList<Integer> idList = new ArrayList<Integer>();
		String ids = event.getIdList();
		String[] ides = ids.split(";");
		for(int i=0; i < ides.length; i++)
		{
			idList.add(Integer.parseInt(ides[i]));
		}
		LmaxEvent newEvent =  new LmaxEvent(newId,-1,idList, false);
		return newEvent;
	}
}
