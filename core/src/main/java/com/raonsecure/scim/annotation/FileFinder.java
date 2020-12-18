package com.raonsecure.scim.annotation;

import java.io.File;

public interface FileFinder {
	public void visit(File root, File file);
}
