package com.gizmosoft.todoapp.web.initializer;

import com.gizmosoft.todoapp.web.springconf.SpringRootContext;
import com.gizmosoft.todoapp.web.springconf.SpringWebContextConfigurator;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JavaWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // this file is the substitute for a web.xml file in Spring Framework

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringRootContext.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringWebContextConfigurator.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/", "*.html"};
    }

}
