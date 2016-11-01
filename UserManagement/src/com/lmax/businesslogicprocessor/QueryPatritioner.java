package com.lmax.businesslogicprocessor;

import java.util.ArrayList;
import com.lmax.vo.LmaxEvent;
import com.redis.Proyecto;

public class QueryPatritioner {
	
	public static ArrayList<Object> partitionEvent(LmaxEvent event)
	{
		ArrayList<Object> eventList =  new ArrayList<Object>();
		ArrayList<Integer> idList = event.getIdList();
		for(int i= 0; i < idList.size(); i++)
		{
			int id = idList.get(i);
			//Call merge with id
			Proyecto cargarProy = new Proyecto();
		    cargarProy = Proyecto.cargarProyecto(""+id);
			eventList.add(cargarProy);			
		}
		return eventList;
	}
}
