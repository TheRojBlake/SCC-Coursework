package com.eduonix.projectbackend.controller;

import com.eduonix.projectbackend.model.User;
import com.eduonix.projectbackend.model.repository.UserRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController is a convenience annotation for creating Restful controllers. 
//It is a specialization of @Component and is autodetected through classpath 
//scanning. It adds the @Controller and @ResponseBody annotations. It converts 
//the response to JSON or XML.
@RestController
public class ApiController
{
    //Autowiring feature of spring framework enables you to inject the object 
    //dependency implicitly.
    @Autowired
    UserRepository repo; //Makes instance of userrepository class.
    
    //Used to map web requests to Spring Controller methods
    //value - specified URL path of request
    //produces - specified the request mapping types 
    @RequestMapping(value="/api/getUsername", produces="application/json")
    
    //A Principal is a Java interface, principals are the unique keys we use in 
    //access control lists
    public Object getUsername(Principal principle)
    {
        User user = new User();
        Long TestId = 12345L;
        user.setId(TestId);
        user.setName(principle.getName());
        
        repo.save(user); //Saves user to the repo. 
        
        return user; //Returns data to requester
    }
}
