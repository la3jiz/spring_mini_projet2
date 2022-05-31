package com.laziz.tasks.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.laziz.tasks.entities.Person;
import com.laziz.tasks.entities.Task;
import com.laziz.tasks.repos.TaskRepository;
	@Service
	public class TaskServiceImpl implements TaskService {
	@Autowired
	TaskRepository taskRepository;
	@Override
	public Task saveTask(Task t) {

	return taskRepository.save(t);
	}
	@Override
	public Task updateTask(Task t) {
	return taskRepository.save(t);
	}
	@Override
	public void deleteTask(Task t) {
	taskRepository.delete(t);
	}
	@Override
	public void deleteTaskById(Long id) {
	taskRepository.deleteById(id);
	}
	@Override
	public Task getTask(Long id) {
	return taskRepository.findById(id).get();
	}
	@Override
	public List<Task> getAllTasks() {
	return taskRepository.findAll();
	}
	@Override
	public Page<Task> getAllTasksParPage(int page, int size) {
		return taskRepository.findAll(PageRequest.of(page, size));
		}
	/*@Override
	public List<Task> findByNomProduit(String nom) {
	return taskRepository.findByNomProduit(nom);
	}
	@Override
	public List<Task> findByNomProduitContains(String nom) {
	return taskRepository.findByNomProduitContains(nom);
	}
	@Override
	public List<Task> findByNomPrix(String nom, Double prix) {
	return taskRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Task> findByCategorie(Person categorie) {
	return taskRepository.findByCategorie(categorie);
	}
	@Override
	public List<Task> findByCategorieIdCat(Long id) {
	return taskRepository.findByCategorieIdCat(id);
	}
	@Override
	public List<Task> findByOrderByNomProduitAsc() {
	return taskRepository.findByOrderByNomProduitAsc();
	}
	@Override
	public List<Task> trierProduitsNomsPrix() {
	return taskRepository.trierProduitsNomsPrix();
	}*/

@Override
	public List<Task> findByTaskName(String nomTask) {
		return taskRepository.findByTaskName(nomTask);
		
	}
}
