package com.hm.woo.test.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.apache.log4j.Logger;
import com.hm.woo.domain.bl.log.LoggerFactory;

import com.hm.woo.domain.dao.UserDataDao;
import com.hm.woo.domain.model.AncientHero;

public class UserDataDaoTest {
	
	static Logger logger = null;

	@Before
	public void setUp() throws Exception {
		logger = LoggerFactory.getLogger(this.getClass().getName());
	}
	
	@Test
	public void testLoadUserData(){
		System.out.println("Test load user data ...");
		UserDataDao dao = new UserDataDao();
		String username = "THero";
		AncientHero thero = dao.loadUserData(username);
		
		if (thero != null) {
			String hero_name = thero.getName();
			assert hero_name == username;
		} else {
			System.out.println("Cannot load user data!");
		}
	}
	
	@Test
	public void testSaveUserData() {
		System.out.println("Test save user data ...");
		UserDataDao dao = new UserDataDao();
		String username = "THero";
		AncientHero thero = dao.loadUserData(username);
		
		if (thero != null) {
			thero.setHp(1200);
			thero.setLv(2);
			dao.saveUserData(thero);
		} else {
			System.out.println("Cannot load user data!");
		}
		
	}

}
