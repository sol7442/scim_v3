package com.raonsecure.scim.server;

import com.raonsecure.scim.exception.ScimExeception;
import com.raonsecure.scim.server.spark.SparkEngine;

public abstract class ServerBuilder {
	public final String SERVER_PORT 		= "server.prot";
	public final String SERVER_MAX_THREAD 	= "server.max.thread";
	public final String SERVER_MIN_THREAD 	= "server.min.thread";
	public final String SERVER_IDLE_TIME 	= "server.idle.time";
	public final String SERVER_FRONT_PATH 	= "server.front.path";
	
	public abstract ScimServer build() throws ScimExeception ;

}
