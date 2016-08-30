package model.factory;

import controller.managers.NetworkItemManagerDecorator;
import controller.managers.ResilianceItemManager;
import model.api.Manager;
import model.entity.Item;
import model.manager.ManagerAdapter;
import model.syncManager.ItemSyncManagerImpl;
import network.api.Peer;

public class ManagerFactory {
	public static Manager<Item> createNetworkResilianceItemManager(Peer peer, String who) {
		ManagerAdapter<Item> adapter = new ManagerAdapter<Item>(new ItemSyncManagerImpl());
		NetworkItemManagerDecorator networkD = new NetworkItemManagerDecorator(adapter, peer, who);
		ResilianceItemManager resiNetworkD = new ResilianceItemManager(networkD, peer);
		return resiNetworkD;
	}
}
