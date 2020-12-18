package com.raonsecure.scim.admin;

import com.raonsecure.scim.annotation.ScimAnntorationProcessor;
import com.raonsecure.scim.env.Environment;
import com.raonsecure.scim.exception.ScimExeception;
import com.raonsecure.scim.server.ScimServer;
import com.raonsecure.scim.server.ServerBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminServerBuilder extends ServerBuilder {

	@Override
	public ScimServer build() throws ScimExeception {
		Environment env = Environment.getInstance();
		
		AdminServer server = null;
		try {

			ScimAnntorationProcessor annotaion_processor = new ScimAnntorationProcessor();
			
			String[] class_path_array = System.getProperty("java.class.path").split(";");
			for (String class_path : class_path_array) {
				log.debug("{} " , class_path);
				annotaion_processor.addPath(class_path);
				
			}
			annotaion_processor.process();
			
			
			server = new AdminServer();
			server.build(env);
			
		}catch (Exception e) {
			throw new ScimExeception(e.getMessage(), e);
		}finally {
			
		}
		return server;
	}

}

