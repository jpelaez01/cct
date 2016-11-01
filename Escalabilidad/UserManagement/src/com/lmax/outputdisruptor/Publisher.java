package com.lmax.outputdisruptor;

import com.redis.Proyecto;

public class Publisher {
	public static void publishEvent(Object eventResult)
	{
		// Call interface and then result
		Proyecto proyecto = (Proyecto) eventResult;
        System.out.println("Call interface and then result :" + proyecto.getValor());
	}
}
