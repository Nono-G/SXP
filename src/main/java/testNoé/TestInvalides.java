package testNoé;

import model.api.ItemSyncManager;
import model.factory.SyncManagerFactory;
import model.entity.Item;

public class TestInvalides {

	public static void main(String[] args) {
		ItemSyncManager em = SyncManagerFactory.createItemSyncManager();
		em.begin();
		Item i = (Item)em.findOneById("08CB3ABA-D356-4416-AE69-6922E0414133");
		System.out.println(i);
		i.setTitle("a");
		boolean x = em.end();
		System.out.println(x);
		System.out.println("Fini");
	}

}
