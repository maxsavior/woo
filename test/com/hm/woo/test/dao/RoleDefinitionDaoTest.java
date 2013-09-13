package com.hm.woo.test.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hm.woo.domain.dao.RoleDefinitionDao;
import com.hm.woo.domain.model.CustomRole;

public class RoleDefinitionDaoTest {
	
	@Test
	public void testGetRoleDefinitions() {
		String rolename = "ranger";
		
		RoleDefinitionDao dao = new RoleDefinitionDao();
		CustomRole ranger = dao.getRole(rolename);
		
		String ranger_rolename = ranger.getRolename();
		int ranger_basichp = ranger.getBasicHp();
		int ranger_incrdef = ranger.getIncrDef();
		
		assert ranger_rolename == rolename;
		
		System.out.println(ranger_basichp);
		System.out.println(ranger_incrdef);
	}

}
