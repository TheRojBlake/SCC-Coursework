package Proj_Backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.tomcat.util.http.fileupload.FileUtils;
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
    
    @CrossOrigin(origins = "http://localhost:4200")   
    //@GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
    /*
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
    */
    
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
    
    @CrossOrigin(origins = "http://localhost:4200")   
    @PostMapping(path = "/POSTtest")
    public void Postdata(@RequestParam Map<String, String> requestParams) throws Exception
    {

        ArrayList<Shares> shareList = new ArrayList<Shares>();
        
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
        System.out.println(date);
        
        share1_2.setCurrency(Share_Currency);
             
        float s_v = Float.parseFloat(Share_Value);
        share1_2.setValue(s_v);
        
        share1.setSharePrice(share1_2);
        
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
        
        
        try
        { 
            Files.deleteIfExists(Paths.get("C:\\Users\\user\\Workspaces\\Angular IDE\\SSC-Frontend\\src\\assets\\Shares_Data.xml")); 
        }
        
        catch(NoSuchFileException e) 
        { 
            System.out.println("No such file/directory exists"); 
        } 
        
        catch(DirectoryNotEmptyException e) 
        { 
            System.out.println("Directory is not empty."); 
        } 
        
        catch(IOException e) 
        { 
            System.out.println("Invalid permissions."); 
        }
          
        System.out.println("Deletion successful.");
        
        
        File src = new File ("C:\\Users\\user\\Documents\\MEGAsync\\University (Main Copy)\\Year 3 Work\\COMP30231 - SSC\\Coursework\\New Work\\SCCBackendApplication\\Shares_Data.xml");
        
        File dest = new File ("C:\\Users\\user\\Workspaces\\Angular IDE\\SSC-Frontend\\src\\assets\\Shares_Data.xml");
               
        copy(src, dest);
        
        System.out.println("Copy successful");     
    }
    
    public static void copy(File src, File dest) throws IOException 
    {
        InputStream is = null;
        OutputStream os = null;
        try 
        {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            // buffer size 1K
            byte[] buf = new byte[40000];

            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) 
            {
                os.write(buf, 0, bytesRead);
            }
        } 
        
        finally 
        {
            is.close();
            os.close();
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200")   
    @PostMapping(path = "/ShareDataRequest")
    public ArrayList<String> ShareDataRequest(@RequestParam Map<String, String> requestParams) throws Exception
    {
        System.out.println("Data recieved:" + requestParams);
                
        String Chosen_Data_View = requestParams.get("chosen_data_view");
        
        ArrayList<String> response = new ArrayList<String>();
                
        if ("Highest Share".equals(Chosen_Data_View))
        {
            JAXBContext context = JAXBContext.newInstance(SharesList.class);
            Unmarshaller um = context.createUnmarshaller();
            SharesList sharelist2 = (SharesList) um.unmarshal(Shares_File);
            ArrayList<Shares> unmarshlist = sharelist2.getBooksList();
            ArrayList<Shares> ResponseList;
            for (Shares share : unmarshlist)
            {
                System.out.println("Shares company: " + share.getCompanyName() + ". Share amount: " + share.getNumOfShares());
            }
        }
        
        else if ("Lowest Share".equals(Chosen_Data_View))
        {
            System.out.println("It Works!");
        }
        
        else if ("Earliest Share".equals(Chosen_Data_View))
        {
           response.add("Please select an option!");
        }
        
        return response;
    }
}
