package com.raonsecure.scim.admin;

import com.raonsecure.scim.env.Environment;
import com.raonsecure.scim.exception.ScimExeception;
import com.raonsecure.scim.server.ScimServer;
import com.raonsecure.scim.server.spark.SparkEngine;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminServer implements ScimServer {

	SparkEngine engine;
	
	@Override
	public ScimServer initialize() throws ScimExeception {
		// TODO Auto-generated method stub
		return null;
	}

	public void build(Environment env) throws ScimExeception{
		try {
			engine = SparkEngine.builder()
					.port(env.getInt(SERVER_PORT, 5000))
					.maxThread(env.getInt(SERVER_MAX_THREAD	, 10))
					.minThread(env.getInt(SERVER_MIN_THREAD	, 5))
					.minThread(env.getInt(SERVER_IDLE_TIME	, 3000))
					.frontPath(env.getString(SERVER_FRONT_PATH,"../front"))
					.build();	
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}finally {
			log.info("{}", engine);
		}
	}

}
