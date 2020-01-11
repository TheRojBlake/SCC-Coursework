package Proj_Backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    
    /*
    //need to pass all values as strings then 
    @PostMapping(path = "/POSTtest")
    public void Postdata(@RequestParam("companyname") String testvar) throws Exception
    {        
        System.out.println("Data: " + testvar);
    }
    */
    
    @PostMapping(path = "/POSTtest")
    public void Postdata(@RequestParam Map<String, String> requestParams) throws Exception
    {
        System.out.println("recived data:" + requestParams);
        
        String Company_Name = requestParams.get("company_name");
        String Company_Symbol = requestParams.get("company_symbol");
        String Num_Of_Shares = requestParams.get("num_of_shares");
        String Last_Share_Update = requestParams.get("last_share_update");
        String Share_Currency = requestParams.get("currency");
        String Share_Value = requestParams.get("share_value");
        
        System.out.println("Data 1: " + Company_Name);
        System.out.println("Data 2: " + Company_Symbol);
        System.out.println("Data 3: " + Num_Of_Shares);
        System.out.println("Data 4: " + Last_Share_Update);
        System.out.println("Data 5: " + Share_Currency);
        System.out.println("Data 6: " + Share_Value);
        
        
        Shares share1 = new Shares();
        SharePrice share1_2 = new SharePrice();
        share1.setCompanyName(Company_Name);
        share1.setCompanySymbol(Company_Symbol);
        
	int nos = Integer.parseInt(Num_Of_Shares);			        
        share1.setNumOfShares(nos);
        
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
        Date date = format.parse(Last_Share_Update);
        share1.setLastShareUpdate(date);
        
        share1_2.setCurrency(Share_Currency);
             
        float s_v = Float.parseFloat(Share_Value);
        share1_2.setValue(s_v);
        
        share1.setSharePrice(share1_2);

        /* 
        shareList.add(share1);
        
        SharesList sharelist = new SharesList();
        sharelist.setBookList(shareList);
        
        
        //Marshelling code
        try 
        {   
            //The JAXBContext class provides the client's entry point to the JAXB API
            JAXBContext context = JAXBContext.newInstance(SharesList.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);                     

            Unmarshaller um = context.createUnmarshaller();
            SharesList sharelist2 = (SharesList) um.unmarshal(Shares_File);
            ArrayList<Shares> unmarshlist = sharelist2.getBooksList();

            shareList.addAll(unmarshlist);

            m.marshal(sharelist, Shares_File);

            System.out.println("Record has been added");
        }

        catch (javax.xml.bind.JAXBException ex) 
        {            
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        */
    }
}
