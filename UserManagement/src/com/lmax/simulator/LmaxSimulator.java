package com.lmax.simulator;

import com.lmax.inputdisruptor.InputDisruptor;
import com.lmax.outputdisruptor.OutputDisruptor;

public class LmaxSimulator {
	public static void main(String[] args) {
		System.gc();
		InputDisruptor.startProcessing();
		OutputDisruptor.startProcessing();
		int retries = 2;
		int retry = 0;
		int totalRequests = 30;
		while(retry < retries)
		{
			String idList = "";
			for(int i= 1; i < totalRequests; i++)
			{
				if(i == totalRequests-1)
					idList += (i+(totalRequests*retry)) ;
				else
					idList += (i+(totalRequests*retry)) + ";";
			}
			//System.out.println("Recieved event with IDs :" + idList);
			InputDisruptor.recieveEvent(idList);
			retry++;
		}
	}
}
