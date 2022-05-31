package com.laziz.tasks.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.laziz.tasks.entities.Person;
import com.laziz.tasks.entities.Task;
    @RepositoryRestResource(path = "rest")
	public interface TaskRepository extends JpaRepository<Task, Long> {
    
    	
    	@Query("select t from Task t where t.nomTask like %:ntask% ")
		List<Task> findByTaskName( String ntask);
    	
		/*List<Task> findByNomProduit(String nom);
		List<Task> findByNomProduitContains(String nom);
		List<Task> findByCategorieIdCat(Long id);
		List<Task> findByOrderByNomProduitAsc();*/
		
		/*@Query("select p from Task p where p.nomNorriture like %:nom and p.prixNorriture > :prix")
		List<Task> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
		
		@Query("select p from Task p where p.categorie = ?1")
		List<Task> findByCategorie (Person categorie);
		
		@Query("select p from Task p order by p.nomNorriture ASC, p.prixNorriture DESC")
		List<Task> trierProduitsNomsPrix ();*/
	}
	

