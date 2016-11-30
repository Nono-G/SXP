package testsModelSXP;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import model.api.*;
import model.entity.*;
import model.factory.*;
import model.manager.*;
import model.syncManager.*;
import model.validator.*;

public class test1 {

	public static void main (String[] args){
		ItemSyncManager ism = SyncManagerFactory.createItemSyncManager();
		ism.begin();
		Item i = new Item();
		System.out.println("Premier persist...");
		ism.persist(i);
		System.out.println("Premier persist... OK");
		i.setCreatedAt(new Date());
		i.setDescription("Un objet ajouté pour tester2");
		i.setPbkey(new BigInteger("6667",10));
		i.setTitle("MonObj2");
		i.setUserid("NonoID2");
		i.setUsername("NonoNAME2");
		System.out.println("Deuxième persist...");
		ism.persist(i);
		System.out.println("Deuxième persist... OK");
		ism.end();
		Collection<Item> items = ism.findAll();
		int x = 0;
		for(Item unitem : items){
			System.out.println(x+" : "+unitem.getId()+" : "+unitem.getDescription());
			x++;
		}
		System.out.println("Fini");
	}
}
