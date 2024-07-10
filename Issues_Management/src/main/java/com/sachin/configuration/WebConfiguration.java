package com.sachin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sachin")
public class WebConfiguration implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver viewResolve() {
		InternalResourceViewResolver vrs=new InternalResourceViewResolver();
		vrs.setPrefix("/");
		vrs.setSuffix(".jsp");
		return vrs;
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/res/**")
		.addResourceLocations("/resources/");
		registry.addResourceHandler("/uploading/**")
        .addResourceLocations("file:///E:/uploading/");
	}
	 @Bean
	    public CommonsMultipartResolver multipartResolver() {
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	        multipartResolver.setMaxUploadSize(10485760); // 10 MB
	        return multipartResolver;
	    }
}
