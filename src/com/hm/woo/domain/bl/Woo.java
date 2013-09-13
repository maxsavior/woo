package com.hm.woo.domain.bl;

import org.apache.log4j.Logger;

import com.hm.woo.domain.bl.log.LoggerFactory;

public class Woo {
	
	static String player = "THero";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("Main");
		logger.info("Start");
	}

}
