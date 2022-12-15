package com.razin.vadim.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // использовать не будем, поэтому возвращаем null
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class}; // подствляем наш конфигурационный класс SpringConfig, также как и в webxml
        //мы подставляли путь до applicationContextMVC.xml
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"}; // эквивалентно из web.xml где указывали, что для всех вызовов перенаправляемся на наш диспатчер
    }
}
