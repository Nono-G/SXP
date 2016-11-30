package testsModelSXP;

import java.math.BigInteger;
import java.util.Date;

import model.api.ItemSyncManager;
import model.entity.Item;
import model.factory.SyncManagerFactory;

public class TestAjouterObjets {

	public static void main(String[] args) {
		ItemSyncManager ism = SyncManagerFactory.createItemSyncManager();
		Item i1 = new Item();
		i1.setCreatedAt(new Date());
		i1.setDescription("Stylo Noir PaperMate InkJoy 100 1.0M");
		i1.setPbkey(new BigInteger("1024",10));
		i1.setTitle("Stylo Noir");
		i1.setUserid("id123");
		i1.setUsername("Phil Haplon");
		
		Item i2 = new Item();
		i2.setCreatedAt(new Date());
		i2.setDescription("406 HDI Break, 330 000 km, 2001, Gris métalisé");
		i2.setPbkey(new BigInteger("1025",10));
		i2.setTitle("406 HDI");
		i2.setUserid("id124");
		i2.setUsername("Rick Hochet");
		
		Item i3 = new Item();
		i3.setCreatedAt(new Date());
		i3.setDescription("Ordinateur Dell Inspiron, Intel i3, écran 15.6\"");
		i3.setPbkey(new BigInteger("1026",10));
		i3.setTitle("Ordi Portable Dell");
		i3.setUserid("id125");
		i3.setUsername("Pat Apont");
		
		Item i4 = new Item();
		i4.setCreatedAt(new Date());
		i4.setDescription("Microsoft/Nokia Lumia 640 Bleu, Windows Phone 8.1, écran cassé");
		i4.setPbkey(new BigInteger("1027",10));
		i4.setTitle("Téléphone Lumia 640");
		i4.setUserid("id126");
		i4.setUsername("Noé Goudian");
		
		Item i5 = new Item();
		i5.setDescription("Le vilain petit canard");
		
		ism.begin();
		
		ism.persist(i4);
		ism.persist(i3);
		ism.persist(i2);
		ism.persist(i1);
		//ism.persist(i5);
		
		if(ism.end()){
			System.out.println("Changements repercutés dans la base");
		}else{
			System.out.println("ERREUR lors de end, changements non repercutés");
		}
		System.out.println("Fini");
	}

}
