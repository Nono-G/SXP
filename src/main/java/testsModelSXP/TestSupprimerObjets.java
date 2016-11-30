package testsModelSXP;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;

import model.api.*;
import model.entity.*;
import model.factory.*;
import model.manager.*;
import model.syncManager.*;
import model.validator.*;

public class TestSupprimerObjets {

	public static void main(String[] args) {
		ItemSyncManager ism = SyncManagerFactory.createItemSyncManager();
		ism.begin();
		Collection<Item> items = ism.findAll();
		Iterator<Item> iter = items.iterator();
		while(iter.hasNext()){
			Item i = iter.next();
			ism.remove(i);
		}
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
