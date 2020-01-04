package de.vogella.xml.jaxb.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shareprice")
public class SharePrice
{
    private String currency;
    private float value;
    
    public String getCurrency() 
    {
        return currency;
    }

    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public float getValue() 
    {
        return value;
    }

    public void setValue(float value) 
    {
        this.value = value;
    }
}
