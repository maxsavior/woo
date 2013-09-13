package com.hm.woo.domain.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import com.hm.woo.domain.bl.log.LoggerFactory;

import com.hm.woo.domain.model.CustomRole;

public class RoleDefinitionDao {
	
	public final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	public CustomRole getRole(String rolename){
		CustomRole role = null;
		String role_properties = String.format("./database/role/%s.properties", rolename);
		logger.debug("Role properties file: " + role_properties);
		
		boolean exists = (new File(role_properties)).exists();
		if (exists) {
	        // Read properties file.
	        Properties properties = new Properties();
	        try {
	            properties.load(new FileInputStream(role_properties));
	        } catch (IOException e) {
	        	String log_read_properties_failed = "Failed to read properties! Exception: " + e.toString();
	        	logger.error(log_read_properties_failed);
	        }
	        
	        String key_basichp = "role.basic.hp";
	        String key_basicatk = "role.basic.atk";
	        String key_basicdef = "role.basic.def";
	        String key_incrhp = "role.incr.hp";
	        String key_incratk = "role.incr.atk";
	        String key_incrdef = "role.incr.def";
	        
	        String role_basichp = properties.getProperty(key_basichp);
	        String role_basicatk = properties.getProperty(key_basicatk);
	        String role_basicdef = properties.getProperty(key_basicdef);
	        String role_incrhp = properties.getProperty(key_incrhp);
	        String role_incratk = properties.getProperty(key_incratk);
	        String role_incrdef = properties.getProperty(key_incrdef);
	        
	        if (role_basichp != null && 
	        		role_basicatk != null &&
	        		role_basicdef != null &&
	        		role_incrhp != null &&
	        		role_incratk != null &&
	        		role_incrdef != null) {
	        	int basic_hp = Integer.parseInt(role_basichp);
	        	int basic_atc = Integer.parseInt(role_basicatk);
	        	int basic_def = Integer.parseInt(role_basicdef);
	        	int incr_hp = Integer.parseInt(role_incrhp);
	        	int incr_atk = Integer.parseInt(role_incratk);
	        	int incr_def = Integer.parseInt(role_incrdef);
	        	
	        	role = new CustomRole(rolename, basic_hp, basic_atc, basic_def, incr_hp, incr_atk, incr_def);
	        }
	        
		} else {
			String log_role_properties_not_exist = String.format("%s properties file not exist!", rolename);
			logger.error(log_role_properties_not_exist);
		}
		
		return role;
	}

}
