package de.vogella.xml.jaxb.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//This statement means that class "SharesList.java" is the root-element of our example
@XmlRootElement(namespace = "de.vogella.xml.jaxb.model")
public class SharesList {

    // XmLElementWrapper generates a wrapper element around XML representation
    //@XmlElementWrapper(name = "bookList")
    
    // XmlElement sets the name of the entities
    @XmlElement(name = "share")
    private ArrayList<Shares> bookList;

    public void setBookList(ArrayList<Shares> bookList) 
    {
        this.bookList = bookList;
    }

    public ArrayList<Shares> getBooksList() 
    {
        return bookList;
    }
}