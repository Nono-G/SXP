package testsModelSXP;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

import model.api.ItemSyncManager;
import model.entity.Item;
import model.factory.SyncManagerFactory;

public class TestCheck {

	public static void main(String[] args) {
		ItemSyncManager ism = SyncManagerFactory.createItemSyncManager();
		Item i2 = new Item();
		i2.setCreatedAt(new Date());
		i2.setDescription("406 HDI Break, 330 000 km, 2001, Gris métalisé");
		i2.setPbkey(new BigInteger("1025",10));
		i2.setTitle("406 HDI");
		i2.setUserid("id124");
		i2.setUsername("Rick Hochet");
		
		ism.begin();
		ism.persist(i2);
		dumpWL(ism);
		if(ism.check()){
			System.out.println("Check OK");
		}else{
			System.out.println("Check PAS BON");
		}
		System.out.println("Modification de item :");
		i2.setTitle("E");
		
		dumpWL(ism);
		if(ism.check()){
			System.out.println("Check OK");
		}else{
			System.out.println("Check PAS BON");
		}
		ism.remove(i2);
		dumpWL(ism);
		if(ism.end()){
			System.out.println("END ok");
		}else{
			System.out.println("END pas bon");
		}
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
