package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GalleryPiece;

public class GalleryPieceHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ArtGalleryTaffae");

	public void insertItem(GalleryPiece toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<GalleryPiece> showAllItems() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<GalleryPiece> allResults = em.createQuery("select gp from GalleryPiece gp", GalleryPiece.class);
		List<GalleryPiece> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}

	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();
	}

	public void deleteItem(GalleryPiece toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GalleryPiece> typedQuery = em.createQuery(
				"select gp from GalleryPiece gp where gp.title = :selectedTitle and gp.artistName = :selectedArtistName",
				GalleryPiece.class);
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedArtistName", toDelete.getArtistName());
		typedQuery.setMaxResults(1);
		GalleryPiece result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public GalleryPiece searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		GalleryPiece foundPiece = em.find(GalleryPiece.class, idToEdit);
		em.close();
		return foundPiece;
	}

	public void deletePiece(GalleryPiece toDelete) {
		// TODO Auto-generated method stub

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GalleryPiece> typedQuery = em.createQuery("select gp from GalleryPiece gp where gp.id = :selectedId",
				GalleryPiece.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		GalleryPiece result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void updatePiece(GalleryPiece toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
