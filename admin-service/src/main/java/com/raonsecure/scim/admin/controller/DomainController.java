package com.raonsecure.scim.admin.controller;

import com.raonsecure.scim.annotation.SCIM_CONTROL;

import lombok.extern.slf4j.Slf4j;
import spark.Request;
import spark.Response;
import spark.Route;

@Slf4j
@SCIM_CONTROL(name = "domain",path = "/admin/domain")
public class DomainController {
	public Route create() {
		return new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				try {
					
				}catch (Exception e) {
					log.error(e.getMessage(), e);
				}finally {
					log.debug("");
				}
				return null;
			}
		};
	}
}
