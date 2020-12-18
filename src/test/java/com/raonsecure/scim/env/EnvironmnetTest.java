package com.raonsecure.scim.env;

import org.apache.commons.configuration2.PropertiesConfigurationLayout;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.Test;

public class EnvironmnetTest {

	String file = "./config/environment.env";
	
	@Test
	public void save() {
		try {
			Environment env = Environment.getInstance();
			
//			env.addProperty("key","value");
//			PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout();
//			layout.setComment("key","comment");
//			env.setLayout(layout);
			
			env.save(file);
			
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	//@Test
	public void load_save() {
//		try {
//			Environment env = Environment.load(file);
//			
//			env.addProperty("key","value");
//			PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout();
//			layout.setComment("key","comment");
//			env.setLayout(layout);
//			
//			env.save(file);
//			
//		} catch (ConfigurationException e) {
//			e.printStackTrace();
//		}
	}
}
