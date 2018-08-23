package com.almundo.callcenter;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;



import org.junit.Assert;
import org.junit.Test;

/***
 * Casos de pruebas
 * @author said.hernandez
 *
 */
public class CallCenterTest {
	
	private final Integer MIN_NUMERO = 30000000; 
	private final Integer MAX_NUMERO = 32199999; 
  

	 @Test
	  public void testCallCenter() {
		URL url;
		for(int i = 0; i < 10; i++){
			try {
				Integer numero = new Random().nextInt((MAX_NUMERO - MIN_NUMERO) + 1) + MAX_NUMERO;
				url = new URL("http://localhost:8080/dispatcher/call?numero=" + numero);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
			    Assert.assertEquals("Error ", 200, conn.getResponseCode());
			    System.out.print(conn.getResponseMessage()); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	  }
}
