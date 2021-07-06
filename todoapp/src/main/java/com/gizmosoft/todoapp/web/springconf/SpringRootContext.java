package com.gizmosoft.todoapp.web.springconf;

import com.gizmosoft.todoapp.config.SpringDBConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.gizmosoft.todoapp.dao","com.gizmosoft.todoapp.service"})
@Import(SpringDBConfig.class)
public class SpringRootContext {
}
