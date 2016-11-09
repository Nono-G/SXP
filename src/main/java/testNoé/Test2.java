package testNoé;

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
		Item i = ism.findOneById("4D7163B9-3CCC-43A9-8B8F-BAF6A3983540");
		dumpWL(ism);
		System.out.println("persist");
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
		dumpWL(ism);
		testContains(ism, i2);
		testContains(ism, i);
		System.out.println("rebegin");
		ism.begin();
		testContains(ism, i2);
		testContains(ism, i);
		dumpWL(ism);
		ism.end();
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
