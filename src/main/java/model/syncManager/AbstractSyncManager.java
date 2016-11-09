package model.syncManager;

import java.util.Collection;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import org.eclipse.persistence.internal.jpa.EntityManagerImpl;


public class AbstractSyncManager<Entity> implements model.api.SyncManager<Entity>{
	//protected Set<Entity> watchlist;
	private EntityManagerFactory factory;
	private EntityManager em;
	private Class<?> theClass;
	@Override
	public void initialisation(String unitName, Class<?> c) {
		factory = Persistence.createEntityManagerFactory(unitName);
		this.theClass = c;
		em = factory.createEntityManager();
		//watchlist = new HashSet<Entity>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Entity findOneById(String id) {
		return (Entity) em.find(theClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Entity> findAll() {
		Query q = em.createQuery("select t from " + theClass.getSimpleName() + " t");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Entity findOneByAttribute(String attribute, String value) {
		Query q = em.createQuery("select t from " + theClass.getSimpleName() + " t where t."+ attribute + "=:value");
		q.setParameter("value", value);
		try {
			return (Entity) q.getSingleResult();
		} catch(Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Entity> findAllByAttribute(String attribute, String value) {
		Query q = em.createQuery("select t from " + theClass.getSimpleName() + " t where t."+ attribute + "=:value");
		q.setParameter("value", value);
		try {
			return q.getResultList();
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public void begin() {
		em.getTransaction().begin();
	}

	@Override
	
	public void check(){
		//néant
	}
	
	@Override
	public boolean end() {
		//Valider toutes les entités de la watchlist
		//  A FAIRE
		try{
			em.getTransaction().commit();
			return true;
		}catch(RollbackException r){
			//Rollback Exception est une "runtime" donc pas obligatoire de la catcher
			//Renvoyer un truc pour signaler l'erreur ???
			//Ici il n'est pas possible de donner plus d'informations que Vrai ou Faux, cf l'atomicité des transactions SQL
			return false;
		}
		//End doit vider la WL puisque contains ne peut pas être appelé sur une transaction fermée.
	}
                 
	@Override
	public void persist(Entity entity) {
		em.persist(entity);
		//watchlist.add(entity);
	}
	
	@Override
	public boolean contains(Entity entity){
		return em.contains(entity);
	}

	/**
	 * Ici on fait des choses pas très propres !
	 * Des casts pas trop vérifiés, il faut croiser les doigts
	 * Des accès à des méthodes bien cachées qu'on ne comprend pas tout à fait,...
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Entity> watchlist() {
		EntityManagerImpl emi = (EntityManagerImpl)em;
		Map<Object,Object> wlMap = emi.getActivePersistenceContext(null).getCloneMapping();
		return (Collection<Entity>) wlMap.keySet();
	}	
}
