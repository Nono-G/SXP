package testDamien;

import java.util.Date;

import model.api.MessageSyncManager;
import model.entity.Message;
import model.factory.SyncManagerFactory;

public class TestDamien01 {

	public static void main(String[] args) {
		MessageSyncManager msm = SyncManagerFactory.createMessageSyncManager();
		System.out.println(msm.begin());
		
		Message msg = new Message();
		msm.persist(msg);
		
		msg.setObject("Nouveaux trucs");
		msg.setSender("001", "JP ABC");
		msg.setSendingDate(new Date());
		msg.setBody("Messieurs\n Je recherche activement des trucs a échanger\n");
	
		msg.addReceivers("002", "A BC");
		msg.addReceivers("003", "B CD");
		
		msg.setStatus(Message.ReceptionStatus.DRAFT);
		
		System.out.println(msm.end());
		
	}
}
