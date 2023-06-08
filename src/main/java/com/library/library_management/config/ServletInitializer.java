package com.library.library_management.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {ServletConfig.class};

    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
       return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
