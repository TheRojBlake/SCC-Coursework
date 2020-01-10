package Proj_Backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import javax.xml.parsers.*;
import org.springframework.util.StreamUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

@RestController
public class GreetingController 
{
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    File Shares_File = new File("Shares_Data.xml");
    ArrayList<Shares> shareList = new ArrayList<Shares>();

    @CrossOrigin(origins = "http://localhost:4200")   
    //@GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) 
    {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(required=false, defaultValue="Everyone") String name) 
    {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping(value = "/testapi", method = RequestMethod.GET, produces="application/xml")
    public Shares getData()
    {   
        System.out.println("==== in greeting ====");
        Shares share1 = new Shares();
        SharePrice share1_2 = new SharePrice();
        share1.setCompanyName("test");
        share1.setCompanySymbol("test");
        share1.setNumOfShares(123);
        Date date = new Date();
        share1.setLastShareUpdate(date);
        share1_2.setCurrency("dollar");
        share1_2.setValue(12345f);
        share1.setSharePrice(share1_2);
        
        return share1;
    }
    
    @RequestMapping(value = "/POSTtest", method = RequestMethod.POST, produces="application/xml")
    public Shares Postdata()
    {   
        System.out.println("==== in greeting ====");
        Shares share1 = new Shares();
        SharePrice share1_2 = new SharePrice();
        share1.setCompanyName("test");
        share1.setCompanySymbol("test");
        share1.setNumOfShares(123);
        Date date = new Date();
        share1.setLastShareUpdate(date);
        share1_2.setCurrency("dollar");
        share1_2.setValue(12345f);
        share1.setSharePrice(share1_2);
        
        return share1;
    }
    
    @RequestMapping(value = "/sendData", method = RequestMethod.GET, produces="application/xml")
    public void SendData(OutputStream out)
    {
        try (InputStream is = new FileInputStream("Shares_Data.xml")) 
        {
            StreamUtils.copy(is, out);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    } 
}
