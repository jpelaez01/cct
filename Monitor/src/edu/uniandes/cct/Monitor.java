package edu.uniandes.cct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Monitor {
	public static void main(String[] args) {

		HttpClient client = new DefaultHttpClient();

		HttpGet request = new HttpGet("http://localhost:8080/UserManagement/rest/UserService/monitoring");

		HttpResponse response;
		try {
			response = client.execute(request);

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			SAXBuilder saxBuilder = new SAXBuilder();
			String message = "";
			while ((line = rd.readLine()) != null) {

				System.out.println(line);
				Document doc = saxBuilder.build(new StringReader(line));
				message = doc.getRootElement().getChildText("coreAvailable");
				System.out.println(message);
				message = doc.getRootElement().getChildText("memoryAvailable");
				System.out.println(message);
				if (Integer.parseInt(message) > 75) {
					// Reiniciar el Tomcat el componente
		             try {
		                    Runtime.getRuntime().exec("cmd /c start C:\\CCT\\restartTomcat.bat");
		             } catch (IOException e) {
		                    System.out.println("aca esta pasando algo con el restartTomcat.bat");
		             }
				}
				message = doc.getRootElement().getChildText("DBStatus");
				System.out.println(message);
				if (!message.equals("Ok")) {
					// Reiniciar Base de datos
					try {
	                    Runtime.getRuntime().exec("cmd /c start C:\\CCT\\restartDB.bat");
	                } catch (IOException e) {
	                    System.out.println("aca esta pasando algo con el restartDB.bat");
	             }
				}

			}

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
