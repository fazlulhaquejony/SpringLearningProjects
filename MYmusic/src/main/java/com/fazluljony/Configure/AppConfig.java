package com.fazluljony.Configure;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configurable
@EnableAsync
@ComponentScan(basePackages="com.fazluljony")
public class AppConfig {

    @Bean
    public ViewResolver viewresolver()
    {
    	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    	viewResolver.setPrefix("WEB-INF/view");
    	viewResolver.setSuffix(".jsp");
    	
    	return viewResolver;
    }

}
