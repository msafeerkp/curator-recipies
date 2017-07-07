package org.learning.curator.recipies.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

public class Participant {
	
	private InterProcessMutex mutex;
	
	public Participant(CuratorFramework client, String path) {
		
		mutex = new InterProcessMutex(client, path);
		
	}
	
	public void acquire() throws Exception{
		try {
			mutex.acquire();
		} catch (Exception e) {
			System.out.println("Exception occured while acquiring the lock.");
			throw e;
		}
	}
	
	public void release() throws Exception{
		try {
			mutex.release();
		} catch (Exception e) {
			System.out.println("Exception occured while releasing the lock.");
			throw e;
		}
	}

}
