package com.zfcom.cft.webListener;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.zfcom.cft.services.DeamonHeartbeatIPService;


@WebListener
public class LaunchListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent paramServletContextEvent) {
		DeamonHeartbeatIPService.main(new String[] {""});
		try {
			Runtime.getRuntime().exec("C:/Program Files/Git/gogs/gogs.exe web");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
		
	}
	
	
	
	
	
}
