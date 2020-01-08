package com.eduonix.projectbackend.security;

import java.io.IOException;

//The javax.servlet package contains a number of classes and interfaces that 
//describe and define the contracts between a servlet class and the runtime 
//environment provided for an instance of such a class by a conforming servlet container.
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

//@Configuration annotation indicates that a class declares one or more @Bean 
//methods and may be processed by the Spring container to generate bean definitions 
//and service requests for those beans at runtime.
@Configuration

// Convenience annotation for enabling an Authorization Server 
//(i.e. an AuthorizationEndpoint and a TokenEndpoint) in the current application context.
@EnableAuthorizationServer

//AuthorizationServerConfigurerAdapter configure the non-security features of 
//the Authorization Server endpoints, like token store, token customizations, 
//user approvals and grant types.
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter
{
    //Autowiring feature of spring framework enables you to inject the object 
    //dependency implicitly.
    @Autowired
    
    //AuthenticationManager processes an Authentication request.
    AuthenticationManager authenticationManager;

    
    //A filter is an object that performs filtering tasks on either the request 
    //to a resource (a servlet or static content), or on the response from a resource, or both.
    static class CorsFilter implements Filter {
        
        //Overriding is a feature that allows a subclass or child class to provide 
        //a specific implementation of a method that is already provided by 
        //one of its super-classes or parent classes.
        @Override
        
        //When container offloads the Filter instance, it invokes the destroy() 
        //method. This is the method where we can close any resources opened by 
        //filter. This method is called only once in the lifetime of filter.
        public void destroy()
        {
            
        }

        @Override
        //The doFilter method of the Filter is called by the container each time
        //a request/response pair is passed through the chain due to a client 
        //request for a resource at the end of the chain.
        //serverletRequest - Defines an object to provide client request information to a servlet.
        //ServletResponse - Defines an object to assist a servlet in sending a response to the client
        //FilterChain - A FilterChain is an object provided by the servlet container 
                //giving a view into the invocation chain of a filtered request for a resource
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) 
                throws IOException, ServletException
        {
            //Extends the ServletRequest interface to provide request information for HTTP servlets.
            HttpServletRequest req = (HttpServletRequest) request;
            
            //Extends the ServletResponse interface to provide HTTP-specific functionality in sending a response
            HttpServletResponse res = (HttpServletResponse) response;
            
            //setHeader - Sets a response header with the given name and value
            
            //specifies the authorized domains to make cross-domain request
            res.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
            
            //specifies the method or methods allowed when accessing the resource in response to a preflight request
            res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            
            //Indicates how long the results of a preflight request 
            //(that is the information contained in the Access-Control-Allow-Methods 
            //and Access-Control-Allow-Headers headers) can be cached.
            res.setHeader("Access-Control-Max-Age", "3600");
            
            //indicates which header field names can be used during the actual request.
            res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
            
            //indicates which headers are safe to expose.
            res.setHeader("Access-Control-Expose-Headers", "*");
            
            //specifies if cross-domain requests can have authorization credentials or not.
            res.setHeader("Access-Control-Allow-Credentials", "true");
            
            //getMethod - Returns the name of the HTTP method with which this 
            //request was made, for example, GET, POST, or PUT.
            if (req.getMethod().equalsIgnoreCase("OPTIONS")) 
            {
                res.setStatus(200);
            }
            
            else 
            {
                filter.doFilter(req, res);
            }
        }
        
        //init - Called by the web container to indicate to a filter that it is being placed into service
        @Override
        public void init(FilterConfig arg0) throws ServletException
        {
            
        }
    }

    @Override
    //AuthorizationServerSecurityConfigurer - Sets a new list of custom authentication filters for the TokenEndpoint.
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception
    {
        //addTokenEndpointAuthenticationFilter - An optional authentication 
        //filter for the TokenEndpoint . It sits downstream of another filter 
        //(usually BasicAuthenticationFilter ) for the client, and creates an 
        //OAuth2Authentication for the Spring SecurityContext if the request 
        //also contains user credentials, e.g. as typically would be the case in a password grant.
        security.addTokenEndpointAuthenticationFilter(new CorsFilter());
    }
    
    @Override
    //ClientDetailsServiceConfigurer - will make sure we're using persistence to get the client information from
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception
    {
        //Configures the login details of the client. 
        clients.
                inMemory(). //
                withClient("client").
                secret("{noop}secret").
                authorizedGrantTypes("password").
                resourceIds("oauth2-resource").
                scopes("read");
    }
    
    @Override
    //AuthorizationServerEndpointsConfigurer - Configure the properties and enhanced functionality of the Authorization Server endpoints.
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception
    {
        //authenticationManager - Processes an Authentication request.
        endpoints.authenticationManager(authenticationManager);
    }
}
