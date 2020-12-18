package com.raonsecure.scim.env;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.PropertiesConfigurationLayout;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Environment extends PropertiesConfiguration  {
	static Environment instance = null;
	
	public static Environment load(String file) {
		try {
			instance = new Environment();
			Configurations configs = new Configurations();
			instance.append(configs.properties(file));	
		}catch(Exception e) {
			log.error(e.getMessage() + " : " + file,e);
		}finally {
			log.debug("load : {}", file);
		}
		

		return instance; 
	}
	public static Environment getInstance() {
		if(instance == null) {
			instance = new Environment();
		}
		return instance;
	}
	public void save(String file) throws ConfigurationException {
		Configurations configs = new Configurations();
		
		FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configs.propertiesBuilder(file);
		//builder.getConfiguration();
		PropertiesConfiguration config = builder.getConfiguration();
		config.addProperty("key","value");
		
		PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout();
		layout.setComment("key","comment");
		config.setLayout(layout);
		
		config.addProperty("key2","value2");
		
		builder.save();
	}
}
