package com.raonsecure.scim.annotation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScimAnntorationProcessor {
	
	List<File> searchPaths = new ArrayList<File>();
	List<ScimAnnotationHandler> handlers = new ArrayList<ScimAnnotationHandler>();

	ScimAnnotaionFinder finder = new ScimAnnotaionFinder();
	
	
	public void addPath(String path) {
		File file = new File(path);
		if(file.exists()) {
			this.searchPaths.add(file);
		}else {
			log.warn("{} is not found", file);
		}
		
	}
	public void addHandler(ScimAnnotationHandler handler) {
		handlers.add(handler);
	}
	
	public void process() {
		for (File file : searchPaths) {
			finder.find(file);
		}
	}
	
	
}
