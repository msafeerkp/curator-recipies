package org.learning.curator.recipies.leader;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;

public class LeaderParticipant extends LeaderSelectorListenerAdapter{

	private LeaderSelector leaderSelector;
	
	public LeaderParticipant(CuratorFramework client, String leaderPath) {
		leaderSelector = new LeaderSelector(client, leaderPath, this);
		leaderSelector.autoRequeue();
	}
	
	public void start() {
		leaderSelector.start();
	}
	
	@Override
	public void takeLeadership(CuratorFramework client) throws Exception {
		System.out.println("Leadership is acquired...");
		Thread.currentThread().join(0);
	}
}
