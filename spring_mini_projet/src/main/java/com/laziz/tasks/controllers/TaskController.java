package com.laziz.tasks.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laziz.tasks.entities.Person;
import com.laziz.tasks.entities.Role;
import com.laziz.tasks.entities.Task;
import com.laziz.tasks.entities.User;
import com.laziz.tasks.service.PersonService;
import com.laziz.tasks.service.RoleService;
import com.laziz.tasks.service.RoleServiceImpl;
import com.laziz.tasks.service.TaskService;
import com.laziz.tasks.service.UsersService;
import com.laziz.tasks.service.UsersServiceImpl;

@Controller
public class TaskController {
	@Autowired
	TaskService taskService;
	@Autowired
	PersonService personService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Person> pers = personService.findAll();
		Task task = new Task();
		Person per = new Person();
		per = pers.get(0); // prendre la première catégorie de la liste
		task.setPerson(per); // affedter une catégorie par défaut au produit pour éviter le pb avec une
								// catégorie null
		modelMap.addAttribute("persons", pers);
		modelMap.addAttribute("task", new Task());
		modelMap.addAttribute("mode", "new");
		return "formTask";
	}

	@RequestMapping("/saveTask")
	public String saveProduit(@Valid Task Task, BindingResult bindingResult) {
		System.out.println(Task);
		if (bindingResult.hasErrors())
			return "formTask";
		taskService.saveTask(Task);

		return "redirect:/ListeTasks";
	}

	@RequestMapping("/showCreatePerson")
	public String showCreateCat(ModelMap modelMap) {
		modelMap.addAttribute("persons", new Person());
		modelMap.addAttribute("mode", "new");
		return "formPerson";
	}

	@RequestMapping("/savePerson")
	public String saveCategorie(@ModelAttribute("person") Person person, ModelMap modelMap) throws ParseException {
		Person saveCategorie = personService.savePerson(person);
		return "redirect:/ListePersons";
	}

	@RequestMapping("/ListePersons")
	public String listeProduits(ModelMap modelMap) {
		List<Person> pers = personService.findAll();
		modelMap.addAttribute("persons", pers);
		return "ListePersons";
	}

	@RequestMapping("/ListeTasks")
	public String listeProduits(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		Page<Task> tasks = taskService.getAllTasksParPage(page, size);
		modelMap.addAttribute("tasks", tasks);
		modelMap.addAttribute("pages", new int[tasks.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeTasks";
	}

	@RequestMapping("/supprimerTask")
	public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		taskService.deleteTaskById(id);
		Page<Task> tasks = taskService.getAllTasksParPage(page, size);
		modelMap.addAttribute("tasks", tasks);
		modelMap.addAttribute("pages", new int[tasks.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeTasks";
	}

	@RequestMapping("/supprimerPerson")
	public String supprimerCategorie(@RequestParam("id") Long id, ModelMap modelMap) {
		personService.deletePersonById(id);
		List<Person> pers = personService.findAll();
		modelMap.addAttribute("persons", pers);
		return "ListePersons";
	}

	@RequestMapping("/modifierTask")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap) {
		Task task = taskService.getTask(id);
		List<Person> pers = personService.findAll();
		pers.remove(task.getPerson());
		modelMap.addAttribute("persons", pers);
		modelMap.addAttribute("task", task);
		modelMap.addAttribute("mode", "edit");
		return "formTask";
	}

	/*@RequestMapping("/updateProduit")
	public String updateProduit(@ModelAttribute("produit") Task Task, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		Task.setDateCreation(dateCreation);

		taskService.updateProduit(Task);
		List<Task> tasks = taskService.getAllProduits();
		modelMap.addAttribute("tasks", tasks);
		return "listeTasks";
	}*/

	@RequestMapping("/modifierPerson")
	public String editerCategorie(@RequestParam("id") Long id, ModelMap modelMap) {
		Person c = personService.getPerson(id);
		modelMap.addAttribute("persons", c);
		modelMap.addAttribute("mode", "edit");
		return "formPerson";
	}

	/*@RequestMapping("/updateCategorie")
	public String updateCategorie(@ModelAttribute("categorie") Person person, ModelMap modelMap) throws ParseException {
		personService.updateCategorie(person);
		List<Person> cats = personService.findAll();
		modelMap.addAttribute("categories", cats);
		return "ListeCat";
	}*/
	

	@RequestMapping("/search")
	public String chercherTask(@RequestParam("nomTask")  String nomTask,ModelMap modelMap)
	{
		List<Person> pers = personService.findAll();
		modelMap.addAttribute("persons", pers);
		List<Task> tasks =taskService.findByTaskName(nomTask);
		modelMap.addAttribute("tasks",tasks);
		modelMap.addAttribute("mode", "SearchTask");
		return "listSearchTask";
	}
	
	
	@RequestMapping("/searchPerson")
	public String chercherPerson(@RequestParam("nomPerson")  String nomPerson,ModelMap modelMap)
	{
		List<Person> pers = personService.findByPersonName(nomPerson);
		modelMap.addAttribute("persons", pers);
		modelMap.addAttribute("mode", "SearchPerson");
		return "listSearchPerson";
	}
	


	
	
	
	@Autowired
	RoleServiceImpl roleService;
	
	@Autowired
	UsersServiceImpl usersService;
	
	
	

@RequestMapping("/saveRole")
public String saveRole(@ModelAttribute("role") Role role,ModelMap modelMap) throws ParseException 
{
	Role saveRole = roleService.saveRole(role);
return "redirect:/ListeUsers";
}
@RequestMapping("/showCreateUser")
public String showCreateUser(ModelMap modelMap)
{
	List<Role> roles = roleService.findAll();
	modelMap.addAttribute("roles", roles);
modelMap.addAttribute("users", new User());
modelMap.addAttribute("mode", "new");
return "FormUser";
}
@RequestMapping("/saveUser")
public String saveUser(@ModelAttribute("user") User user,ModelMap modelMap) throws ParseException 
{
User saveUser = usersService.saveUser(user);
return "redirect:/ListeUsers";
}
@RequestMapping("/ListeUsers")
public String ListeUser(ModelMap modelMap)
{
List <User> users = usersService.findAll();
modelMap.addAttribute("users", users);
return "ListeUsers";
}
@RequestMapping("/modifierUser")
public String modifierUser(@RequestParam("id") Long id,ModelMap modelMap)
{
User u= usersService.getUser(id);
List<Role> role = roleService.findAll();
modelMap.addAttribute("roles", role);
modelMap.addAttribute("users", u);
modelMap.addAttribute("mode", "edit");
return "FormUser";
}
@RequestMapping("/updateUser")
public String updateUser(@ModelAttribute("user") User user,ModelMap modelMap) throws ParseException {
	usersService.updateUser(user);
	 List<User> roles = usersService.findAll();
	 modelMap.addAttribute("users", roles);
	return "ListeUsers";
	}

@RequestMapping("/supprimerUser")
public String supprimerUser(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
usersService.deleteUserById(id);
List<User> roles = usersService.findAll();
modelMap.addAttribute("users", roles);
return "ListeUsers";
}


}