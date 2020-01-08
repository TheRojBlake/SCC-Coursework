//POJO that specifies structure of JSON object being used in the request. 

package com.eduonix.projectbackend.model;

//Javax.persistence handles mapping Java objects to database tables
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//An entity is a lightweight persistence domain object. 
//Typically an entity represents a table in a relational database, 
//and each entity instance corresponds to a row in that table
@Entity

@Table(name="Users") //Specifies name of table being mapped to. 
public class User
{
    //These handle mapping to the database table
    @Id
    @Column(name="id")
    
    //The GeneratedValue annotation may be applied to a primary key property or 
    //field of an entity or mapped superclass in conjunction with the Id annotation.
    @GeneratedValue()
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
