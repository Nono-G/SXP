package model.manager;

import java.util.ArrayList;
import java.util.Collection;

import model.api.Manager;
import model.api.ManagerListener;
import model.api.SyncManager;

public class ManagerAdapter<Entity> implements Manager<Entity>{

	private SyncManager<Entity> em;
	
	public ManagerAdapter(SyncManager<Entity> manager) {
		em = manager;
	}
	
	@Override
	public void findOneById(String id, ManagerListener<Entity> l) {
		ArrayList<Entity> r = new ArrayList<>();
		r.add(em.findOneById(id));
		l.notify(r);
	}

	@Override
	public void findAllByAttribute(String attribute, String value, ManagerListener<Entity> l) {
		l.notify(em.findAllByAttribute(attribute, value));
	}

	@Override
	public void findOneByAttribute(String attribute, String value, ManagerListener<Entity> l) {
		ArrayList<Entity> r = new ArrayList<>();
		r.add(em.findOneByAttribute(attribute, value));
		l.notify(r);
	}

	@Override
	public boolean persist(Entity entity) {
		return em.persist(entity);
	}

	@Override
	public boolean begin() {
		return em.begin();
	}

	@Override
	public boolean end() {
		return em.end();
	}

	@Override
	public boolean remove(Entity entity) {
		return em.remove(entity);
	}

	@Override
	public boolean contains(Entity entity) {
		return em.contains(entity);
	}

	@Override
	public Collection<Entity> watchlist() {
		return em.watchlist();
	}
	
}
