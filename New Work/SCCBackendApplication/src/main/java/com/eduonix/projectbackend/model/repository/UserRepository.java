 //Intended to function as store for users.

package com.eduonix.projectbackend.model.repository;

import com.eduonix.projectbackend.model.User;

//The Java Persistence API (JPA) is the standard way of persisting Java objects 
//into relational databases.
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    
}
