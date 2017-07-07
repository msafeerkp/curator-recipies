package org.learning.curator.recipies.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ConsoleMain {

	public static void main(String[] args) throws Exception {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("localhost:2181", new ExponentialBackoffRetry(1000, 3));
		curatorFramework.start();
		Participant participant = new Participant(curatorFramework, "/curator/lock");
		participant.acquire();
		System.out.println("Lock is acquired...");
		Thread.sleep(30000);
		participant.release();
		System.out.println("Lock is released...");
	}

}
