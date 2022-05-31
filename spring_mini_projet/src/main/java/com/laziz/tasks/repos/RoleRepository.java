package com.laziz.tasks.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laziz.tasks.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>  {

}
