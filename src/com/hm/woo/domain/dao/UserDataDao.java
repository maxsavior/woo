package com.hm.woo.domain.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import com.hm.woo.domain.bl.log.LoggerFactory;

import com.hm.woo.domain.model.AncientHero;
import com.hm.woo.domain.dao.RoleDefinitionDao;
import com.hm.woo.domain.model.CustomRole;

public class UserDataDao {
	
	public final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	static String key_username = "user.name";
	static String key_lv = "user.lv";
	static String key_hp = "user.hp";
	static String key_rolename = "user.role";
	
	public AncientHero loadUserData(String username){
		AncientHero user = null;
		String user_properties = String.format("./database/user/%s.properties", username);
		logger.debug("User properties file: " + user_properties);
		
	    boolean exists = (new File(user_properties)).exists();
	    if (exists) {
	    	user = null;
	    	String msg = String.format("To read user data from '%s.properties'.", username);
	    	logger.debug(msg);
	    	
	        // Read properties file.
	        Properties properties = new Properties();
	        try {
	            properties.load(new FileInputStream(user_properties));
	        } catch (IOException e) {
	        	String log_read_properties_failed = "Failed to read properties! Exception: " + e.toString();
	        	logger.error(log_read_properties_failed);
	        }
	        
            String prop_username = properties.getProperty(key_username);
            
            String prop_lv = properties.getProperty(key_lv);
            
            String prop_hp = properties.getProperty(key_hp);
            
            String prop_rolename = properties.getProperty(key_rolename);
            
            RoleDefinitionDao roleDefDao = new RoleDefinitionDao();
            CustomRole userrole = roleDefDao.getRole(prop_rolename);
            
            if (prop_username != null && 
            		prop_lv != null &&
            		prop_hp != null &&
            		userrole != null) {
            	
            	int userlv = Integer.parseInt(prop_lv);
            	int userhp = Integer.parseInt(prop_hp);
            	user = new AncientHero(prop_username, userlv, userhp, userrole);
            }
            
	    } else {
	    	logger.error(String.format("User properties file '%s' not exist!", user_properties));
	    }		
		return user;
	}
	
	public void saveUserData(AncientHero hero){
		String username = hero.getName();
		
		String user_properties = String.format("./database/user/%s.properties", username);
		
	    // Write properties file.
		Properties properties = new Properties();
	    try {
	    	properties.load(new FileInputStream(user_properties));
	    	
		    int user_lv = hero.getLv();
		    int user_hp = hero.getHp();
		    
		    properties.setProperty(key_hp, Integer.toString(user_hp));
		    properties.setProperty(key_lv, Integer.toString(user_lv));
		    
	        properties.store(new FileOutputStream(user_properties), null);
	    } catch (IOException e) {
        	String log_write_properties_failed = "Failed to write properties! Exception: " + e.toString();
        	logger.error(log_write_properties_failed);
	    }
	    
	}
	
}
