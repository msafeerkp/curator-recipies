package org.learning.curator.recipies.leader;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ConsoleMain {
	
	private String leaderpath = "/test/test/election";
	
	public void participateInLeaderElection() throws InterruptedException {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("localhost:2181", new ExponentialBackoffRetry(1000, 3));
		curatorFramework.start();
		LeaderParticipant leaderParticipant = new LeaderParticipant(curatorFramework, leaderpath);
		leaderParticipant.start();
		Thread.currentThread().join(0);
	}
	
	public static void main(String[] args) throws Exception {
		ConsoleMain consoleMain = new ConsoleMain();
		consoleMain.participateInLeaderElection();
	}

}
