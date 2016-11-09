package model.api;

import java.util.Collection;

/**
 * General interface for entity managers
 * @author Julien Prudhomme
 *
 * @param <Entity> class' entity
 */
public interface SyncManager<Entity> {
	/**
	 * Initialise the entity manager with the unit name
	 * @param unitName unit (entity) name for persistance. See persistance.xml in META-INF
	 */
	public void initialisation(String unitName, Class<?> c);
	
	/**
	 * Find one entity with its Id
	 * @param id entity id
	 * @return An instance of the entity or null.
	 */
	public Entity findOneById(String id);
	
	/**
	 * Return the whole collection of stored entities
	 * @return A collection of entities
	 */
	public Collection<Entity> findAll();
	
	/**
	 * Find all entry with corresponding att/value
	 * @param attribute
	 * @param value
	 * @return
	 */
	public Collection<Entity> findAllByAttribute(String attribute, String value);
	
	/**
	 * Return an object corresponding to the attribute/value
	 * @param attribute
	 * @param value
	 * @return
	 */
	public Entity findOneByAttribute(String attribute, String value);
	
	/**
	 * Persist(insert) this instance to the database
	 * @param entity
	 */
	public boolean persist(Entity entity);
	
	/**
	 * Begin the transaction
	 */
	public boolean begin();
	
	/**
	 * end (commit) the transaction
	 */
	public boolean end();
	
	/**
	 * 
	 * Vérifie à l'aide d'un validateur si les éléments de la Watchlist sont valides ou non.
	 * sous quelle forme renvoyer le résultat ?
	 */
	public void check();
	
	/**
	 * Checks if a given entity is in 'managed' state for this manager.
	 * @param entity
	 * @return true if entity is managed, false otherwise
	 */
	public boolean contains(Entity entity);
	
	/**
	 * Gives a list of the entities currently in a watched state.
	 */
	public Collection<Entity> watchlist();
}
