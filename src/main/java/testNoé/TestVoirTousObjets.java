package testNoé;

import java.util.Set;

import model.api.ItemSyncManager;
import model.entity.Item;
import model.factory.SyncManagerFactory;

public class TestVoirTousObjets {

	public static void main(String[] args) {
		ItemSyncManager ism = SyncManagerFactory.createItemSyncManager();
		ism.begin();
		ism.findAll();
		dumpWL(ism);
		ism.end();
		System.out.println("Fini");
	}
	
	public static void dumpWL(ItemSyncManager ism){
		Set<Item> items = (Set<Item>) ism.watchlist();
		System.out.println("---- Watchlist ----");
		for (Item i : items){
			System.out.println("**************");
			System.out.println(i.getDescription());
			System.out.println(i.getId());
			System.out.println(i.getTitle());
			System.out.println(i.getUserid());
			System.out.println(i.getUsername());
			System.out.println(i.getCreatedAt());
			System.out.println(i.getPbkey());
		}
		System.out.println("-------------------");

	}
}
