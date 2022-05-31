package com.laziz.tasks.service;

import java.util.List;

import com.laziz.tasks.entities.Role;


public interface RoleService {
	 List <Role> findAll();
	    
	 Role saveRole(Role r);
	 Role updateRole(Role r);
	     Role getRole (Long idRole);
}
