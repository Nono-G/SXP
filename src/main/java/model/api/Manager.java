package model.api;

import java.util.Collection;
/**
 * Asynchronous entity manager. Can handle network things
 * @author Julien Prudhomme
 *
 * @param <Entity>
 */
public interface Manager<Entity> {
	
	/**
	 * Find one entity by its id
	 * @param id
	 * @param l
	 */
	public void findOneById(String id, ManagerListener<Entity> l);
	
	/**
	 * Find all entity that match attribute
	 * @param attribute
	 * @param value
	 * @param l
	 */
	public void findAllByAttribute(String attribute, String value, ManagerListener<Entity> l);
	
	/**
	 * Find one that match attribute
	 * @param attribute
	 * @param value
	 * @param l
	 */
	public void findOneByAttribute(String attribute, String value, ManagerListener<Entity> l);
	
	/**
	 * Persist the entity in the manager
	 * @param entity
	 */
	public boolean persist(Entity entity);
	
	/**
	 * Begin a transaction
	 */
	public boolean begin();
	
	/**
	 * End a transaction
	 */
	public boolean end();
	
	/**
	 * Remove an entity from the DB
	 * @param an entity
	 * @return True if the entity has been removed, false otherwise
	 */
	public boolean remove(Entity entity);
	
	/**
	 * Is the entity in a "managed state" ?
	 * i.e. Is it persistent ?
	 * @param entity
	 */
	public boolean contains(Entity entity);
	
	/**
	 * Returns a list of the currentrly "managed" entities.
	 */
	public Collection<Entity> watchlist();
	
	
	/**
	 * Checks if all the managed entities (i.e. the "watchlist") are valid entities.
	 * If the validation at persist() call is activated (default) this will always return true.
	 * Go to bin/META-INF/persistence.xml to change validation mode
	 * @return true if all the managed entities are valid, false otherwise
	 */
	public boolean check();
}
