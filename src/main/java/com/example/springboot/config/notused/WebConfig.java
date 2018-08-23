package com.example.springboot.config.notused;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"com.example.springboot"})
//@Import({WebSecurityConfig.class})
public class WebConfig  {

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/admin/**").addResourceLocations("/admin/");
//    }

    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/"); // без первого слеша работает криво.
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true); //This will make all such beans accessible in plain ${...}
        resolver.setContentType("text/html; charset=utf-8");
        return resolver;
    }
}
