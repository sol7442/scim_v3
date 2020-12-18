package com.raonsecure.scim.server.spark;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import spark.Spark;

@Slf4j
@Data
@Builder
public class SparkEngine {
	
	int port;
	int maxThread;
	int minThread;
	int idleTime;
	
	String frontPath;
	
	boolean initialized;
	public SparkEngine initialize() {
		if(!initialized) {
			Spark.port(port);
			Spark.threadPool(maxThread,minThread,idleTime);
			Spark.staticFileLocation(frontPath);
			
			log.debug("{}",this);
		}else {
		}
		
		return this;
	}
}
