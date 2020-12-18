package com.raonsecure.scim.util.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class RestReadWriteLock implements ReadWriteLock {
    private final Lock readLock;
    private final Lock writeLock;
    private long lockTime;
    
    @Override
   	public Lock readLock() {
   		return readLock;
   	}
   	@Override
   	public Lock writeLock() {
   		return writeLock;
   	}
   	
    
    private RestReadWriteLock() {
    	readLock  = new ReadLock();
    	writeLock = new WriteLock();
    }
    
	public static class ReadLock implements Lock{
		@Override
		public void lock() {
		}

		@Override
		public void lockInterruptibly() throws InterruptedException {
		}

		@Override
		public boolean tryLock() {
			return false;
		}

		@Override
		public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
			return false;
		}

		@Override
		public void unlock() {
		}

		@Override
		public Condition newCondition() {
			return null;
		}
		
	}
	public static class WriteLock implements Lock{
		@Override
		public void lock() {
		}

		@Override
		public void lockInterruptibly() throws InterruptedException {
		}

		@Override
		public boolean tryLock() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void unlock() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Condition newCondition() {
			return null;
		}
	}
}
