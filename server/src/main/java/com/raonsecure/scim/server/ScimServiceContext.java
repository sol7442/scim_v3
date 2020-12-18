package com.raonsecure.scim.server;

import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonController;

public class ScimServiceContext implements DaemonContext {
	private String[] args;
	public ScimServiceContext(String[] args) {
		this.args = args;
	}
	@Override
	public DaemonController getController() {
		return null;//new LancherController();
	}

	@Override
	public String[] getArguments() {
		return this.args;
	}
}
