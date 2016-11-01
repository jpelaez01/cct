package com.lmax.inputdisruptor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lmax.vo.MarshalledEvent;

public class Journaler{
	
	 public static void logEvent(MarshalledEvent event)
	 {
		 File file = new File("C:\\test\\journal.txt");
		 FileWriter writer;
		 try {
			 writer = new FileWriter(file, true);
		     PrintWriter printer = new PrintWriter(writer);
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		     printer.append(sdf.format(new Date()));
		     printer.append(";");
		     printer.append(event.getIdList());
			 printer.append(";");
		     printer.append("\n");
		     printer.close();
		 } catch (IOException e) {
			 // TODO Auto-generated catch block
		     e.printStackTrace();
		 }
	 }
}
