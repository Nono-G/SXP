package testsModelSXP;

import java.util.Set;

import model.api.*;
import model.entity.*;
import model.factory.*;
import model.manager.*;
import model.syncManager.*;
import model.validator.*;

public class Test2 {

	public static void main(String[] args) {
		Item i2 = new Item();
		i2.setDescription("Bateau pirate");
		ItemSyncManager ism = SyncManagerFactory.createItemSyncManager();
		dumpWL(ism);
		testContains(ism, i2);
		System.out.println("begin");
		ism.begin();
		dumpWL(ism);
		testContains(ism, i2);
		System.out.println("find");
		Item i = ism.findOneById("DA5E08FC-0310-413E-9554-FC48D5B62B2D");
		dumpWL(ism);
		System.out.println("persist");
		i.setTitle("J'ai changé");
		ism.persist(i2);
		testContains(ism, i2);
		dumpWL(ism);
		System.out.println("Modif Bateau pirate");
		i2.setDescription("Bateau pirate rose avec des fleurs");
		System.out.println("find all");
		ism.findAll();
		dumpWL(ism);
		testContains(ism, i2);
		testContains(ism, i);
		ism.end();
		System.out.println("end");
		i.setTitle("J'ai changé 2 fois");
		dumpWL(ism);
		testContains(ism, i2);
		testContains(ism, i);
		System.out.println("rebegin");
		ism.begin();
		i.setTitle("J'ai changé 3 fois");
		testContains(ism, i2);
		testContains(ism, i);
		dumpWL(ism);
		ism.end();
		i.setTitle("J'ai changé 4 fois");
		dumpWL(ism);
		
	}
	
	public static void dumpWL(ItemSyncManager ism){
		Set<Item> items = (Set<Item>) ism.watchlist();
		System.out.println("**** Watchlist ****");
		for (Item i : items){
			System.out.println("------------");
			System.out.println(i.getDescription());
			System.out.println(i.getId());
			System.out.println(i.getTitle());
			System.out.println(i.getUserid());
			System.out.println(i.getUsername());
			System.out.println(i.getCreatedAt());
			System.out.println(i.getPbkey());
		}
		System.out.println("******************");
	}
	
	public static void testContains(ItemSyncManager ism, Item i){
		if(ism.contains(i)){
			System.out.println("Contains : OUI");
		}else{
			System.out.println("Contains : NON");
		}
	}

}
