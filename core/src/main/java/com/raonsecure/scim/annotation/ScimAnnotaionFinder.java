package com.raonsecure.scim.annotation;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScimAnnotaionFinder {

	List<Class<?>> classList = new ArrayList<Class<?>>();
	
	public void find(File file) {
		find_file(file,file);
	}
	private void find_file(File root, File file) {
		if(file.isDirectory()) {
			for (File child : file.listFiles()) {
				find_file(root,child);
			}
		}else {
			if(file.getName().endsWith(".jar")) {
				//find_jar(root,file);
			}else if(file.getName().endsWith(".class")) {
				String class_name = create_class_name(root,file);
				log.debug(" - {}", class_name);
				//find_class(class_name);
			}else {
				//ignore
			}
		}
	}

	private void find_jar(File root, File file) {
		try(JarInputStream jarFile = new JarInputStream(new FileInputStream(file))){
			JarEntry jarEntry = null;
			while( (jarEntry = jarFile.getNextJarEntry()) != null) {
				if ((jarEntry.getName().endsWith(".class"))) {
					String class_name = create_class_name(file, jarEntry.getName());
					log.debug(" - {}", class_name);
				}
			}
		} catch (Exception e) {
			
		} 
		
	}

	private String create_class_name(File root, File file) {
		StringBuffer sb = new StringBuffer();
        String fileName = file.getName();
        sb.append(fileName.substring(0, fileName.lastIndexOf(".class")));
        file = file.getParentFile();
        while (file != null && !file.equals(root)) {
            sb.insert(0, '.').insert(0, file.getName());
            file = file.getParentFile();
        }
        
        return sb.toString();
	}
	private String create_class_name(File file, String entry_name) {
		String file_name = entry_name.replaceAll("/", "\\.");
		return file_name.substring(0, file_name.lastIndexOf('.'));
	}


	private void find_class(String class_name) {
		try {
			Class<?> clazz = Class.forName(class_name);
			classList.add(clazz);
		} catch (Exception e) {
			log.warn("{} => {}",e,class_name);
		}
	}
	
}
