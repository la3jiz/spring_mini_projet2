package com.laziz.tasks;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.laziz.tasks.entities.Person;
import com.laziz.tasks.entities.Task;
import com.laziz.tasks.repos.TaskRepository;
import com.laziz.tasks.service.TaskService;

@SpringBootTest
class ProduitApplicationTests {

	/*@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private TaskService taskService ;
	@Test
	public void testCreateProduit() {
	Task prod = new Task("PC Dell",2200.500,new Date());
	taskRepository.save(prod);
	}
	
	
	@Test
	public void testFindProduit()
	{
	Task p = taskRepository.findById(1L).get();

	System.out.println(p);
	}
	@Test
	public void testUpdateProduit()
	{
	Task p = taskRepository.findById(1L).get();
	p.setPrixNorriture(1000.0);
	taskRepository.save(p);
	}
	@Test
	public void testDeleteProduit()
	{
	taskRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousProduits()
	{
	List<Task> prods = taskRepository.findAll();
	for (Task p : prods)
	{
	System.out.println(p);
	}
}*/
	
	/*@Test
	public void testFindByNomProduit()
	{
	List<Task> prods = taskRepository.findByNomProduit("PC Dell");
	for (Task p : prods)
	{
	System.out.println(p);
	}}
	@Test
	public void testFindByNomProduitContains()
	{
	List<Task> prods=taskRepository.findByNomProduitContains("P");
	for (Task p : prods)
	{
	System.out.println(p);
	}}
	@Test
	public void testfindByNomPrix()
	{
	List<Task> prods = taskRepository.findByNomPrix("PC Dell", 2200.5);
	for (Task p : prods)
	{
	System.out.println(p);
	}}
	@Test
	public void testfindByCategorie()
	{
	Person cat = new Person();
	cat.setIdCat(1L);
	List<Task> prods = taskRepository.findByCategorie(cat);
	for (Task p : prods)
	{
	System.out.println(p);
	}}
	@Test
	public void findByCategorieIdCat()
	{
	List<Task> prods = taskRepository.findByCategorieIdCat(1L);
	for (Task p : prods)
	{
	System.out.println(p);
	}}
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Task> prods =

	taskRepository.findByOrderByNomProduitAsc();
	for (Task p : prods)
	{
	System.out.println(p);
	}}
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Task> prods = taskRepository.trierProduitsNomsPrix();
	for (Task p : prods)
	{
	System.out.println(p);
	}}*/
	
}
