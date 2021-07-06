package com.gizmosoft.todoapp.web.springconf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc   // Equivalent to <mvc:annotation-driven />
@ComponentScan(basePackages = "com.gizmosoft.todoapp.web.controller")
public class SpringWebContextConfigurator {
}
