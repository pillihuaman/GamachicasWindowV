package common.System;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.context.annotation.Bean;    
import org.springframework.context.annotation.ComponentScan;    
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;    
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;    
@EnableWebMvc    
@Configuration 
@MultipartConfig(maxFileSize = 5120)
@ComponentScan({ "common.System.controller.*" })    
public class AppConfig  extends WebMvcConfigurerAdapter{    
    @Bean    
    public InternalResourceViewResolver viewResolver() {    
        InternalResourceViewResolver viewResolver    
                          = new InternalResourceViewResolver();    
        //viewResolver.setViewClass(JstlView.class);    
        viewResolver.setPrefix("/WEB-INF/views/Admins/");    
        viewResolver.setSuffix(".jsp");    
        return viewResolver;    
    }    
    
    /**
     * Configure TilesConfigurer.
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/**/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }
 
  

    /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }
     
    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    
}    