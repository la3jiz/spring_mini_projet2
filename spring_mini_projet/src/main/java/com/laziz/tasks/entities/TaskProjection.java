package com.laziz.tasks.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomTask", types = { Task.class })
public interface TaskProjection {
public String getNomTask();
}