package com.hm.woo.domain.bl.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerFactory {
	
	static Logger logger = null;
	
	public static Logger getLogger(String loggerName){
		logger = Logger.getLogger(loggerName);
		PropertyConfigurator.configure("./src/log4j.properties");
		return logger;
		
	}

}
