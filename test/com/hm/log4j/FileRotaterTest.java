package com.hm.log4j;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.hm.woo.domain.bl.log.LoggerFactory;

public class FileRotaterTest {
	
	static Logger logger = null;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	public void testLogger1() {
		logger = Logger.getLogger(this.getClass().getName());
		PropertyConfigurator.configure("./src/log4j.properties");
		
		logger.info("INFO: " + this.getClass().getName());
		logger.debug("DEBUG");
		logger.error("ERROR");
	}

	@Test
	public void testLogger2() {
		
		logger = LoggerFactory.getLogger(this.getClass().getName());
		
		logger.info("INFO: Get from logger factory via static method.");
	}

}
