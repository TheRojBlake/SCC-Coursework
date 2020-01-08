//configures the oauth secutiry

package com.eduonix.projectbackend.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

//@Configuration annotation indicates that a class declares one or more @Bean 
//methods and may be processed by the Spring container to generate bean definitions 
//and service requests for those beans at runtime.
@Configuration

//Convenient annotation for OAuth2 Resource Servers, enabling a Spring Security 
//filter that authenticates requests via an incoming OAuth2 token.
@EnableResourceServer

// @Bean of type ResourceServerConfigurer (e.g. via ResourceServerConfigurerAdapter) that specifies the details of the resource (URL paths and resource id)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{
    private final String resourceId = "oauth2-resource";
    
    @Override
    //ResourceServerSecurityConfigurer - Sets a custom AuthenticationDetailsSource 
    //to use as a source of authentication details
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception
    {
        //resourceId - Identifier of the resource.
        resources.resourceId(resourceId);
    }

    @Override
    //HttpSecurity - It allows configuring web based security for specific http requests
    public void configure(HttpSecurity http) throws Exception
    {
        http.
                //Allows adding a Filter before one of the known Filter classes.
                addFilterBefore(new AuthServerConfig.CorsFilter(), ChannelProcessingFilter.class).
                authorizeRequests().
                anyRequest().
                authenticated().
                and().
                anonymous().
                disable();
    } 
}