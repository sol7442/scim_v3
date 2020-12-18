package com.raonsecure.scim.admin;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

import com.raonsecure.scim.env.Environment;
import com.raonsecure.scim.server.ScimServiceContext;
import com.raonsecure.scim.server.spark.SparkEngine;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScimServiceLancher implements Daemon{
	static ScimServiceLancher lancher = new ScimServiceLancher();
	
	AdminServer server = null;
	
	public static void main(String[] args) {
		try {
			log.info("------------------------------");
			start(args);
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}finally {
			log.info("------------------------------");
		}
	}
	public static void start(String[] args) {
		try {
			lancher.init(new ScimServiceContext(args));
			lancher.start();
		} catch (DaemonInitException e) {
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	public static void stop(String[] args) {
		try {
			lancher.stop();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public void init(DaemonContext context) throws DaemonInitException, Exception {
		Environment env = Environment.load(System.getProperty("config.path")) ;
		log.debug("env : {}", env.getProperty("key"));
		
		
		
		
		server = (AdminServer) new AdminServerBuilder().build().initialize();
	}

	@Override
	public void start() throws Exception {
	}

	@Override
	public void stop() throws Exception {
	}

	@Override
	public void destroy() {
	}
}
