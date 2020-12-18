package com.raonsecure.scim.util.lock;

import java.util.HashMap;
import java.util.Map;

import com.raonsecure.scim.exception.ScimExeception;

public class RestReadWriteLockFactory {
	static Map<String,RestReadWriteLock> locks = new HashMap<String, RestReadWriteLock>();
	
	public static RestReadWriteLock getLock(String key) throws ScimExeception {
		RestReadWriteLock lock = locks.get(key);
		if(lock == null) {
			lock = new RestReadWriteLockBuilder().build(key);
			locks.put(key,lock);
		}
		return lock;
	}
}
