package com.zfcom.cft.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeamonHeartbeatIPService {
	
	private static int __count__ = 0;

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					
					try {
						String urlStr = "http://120.79.248.45:9800/lyg/getip3.jsp?pass=123!";
						URL url = new URL(urlStr);

			            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			            conn.setRequestMethod("GET");

			            conn.setConnectTimeout(10 * 1000);
			            conn.setReadTimeout(10 * 1000);
			            conn.connect();

			            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			            StringBuilder sb = new StringBuilder();
			            String str = null;
			            while ((str = in.readLine()) != null) {
			                sb.append(str);
			            }
			            String responseContent = sb.toString();
			            
			            System.out.println("---------- update count: " + __count__++ + ", " + "update response: " + responseContent);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						System.out.println("---------- Thread wait for 30 minutes.");
						Thread.sleep(30 * 60 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}
			
		}).start();
	}
	
	
}
