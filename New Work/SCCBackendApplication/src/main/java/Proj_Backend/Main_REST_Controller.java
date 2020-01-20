package Proj_Backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main_REST_Controller 
{   
    File Shares_File = new File("Shares_Data.xml");
    
    //Web Method for adding new share data records
    @CrossOrigin(origins = "http://localhost:4200")   
    @PostMapping(path = "/CreateNewShare")
    public void Postdata(@RequestParam Map<String, String> requestParams) throws Exception
    {
        ArrayList<Shares> shareList = new ArrayList<Shares>();
                
        String Company_Name = requestParams.get("company_name");
        String Company_Symbol = requestParams.get("company_symbol");
        String Num_Of_Shares = requestParams.get("num_of_shares");
        String Last_Share_Update = requestParams.get("last_share_update");
        String Share_Currency = requestParams.get("currency");
        String Share_Value = requestParams.get("share_value");
        
        Shares share1 = new Shares();
        SharePrice share1_2 = new SharePrice();
        share1.setCompanyName(Company_Name);
        share1.setCompanySymbol(Company_Symbol);
        
	int nos = Integer.parseInt(Num_Of_Shares);			        
        share1.setNumOfShares(nos);
        
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Last_Share_Update);  
        share1.setLastShareUpdate(date);
        
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

            shareList.addAll(0, unmarshlist);

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
    
    //Method for copying up-to-date info to front-end folder
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
    
    //Web Service for passing specific data record to front-end
    @CrossOrigin(origins = "http://localhost:4200")   
    @PostMapping(path = "/ShareDataRequest")
    public ArrayList<Shares> ShareDataRequest(@RequestParam Map<String, String> requestParams) throws Exception
    {
        System.out.println("Data recieved:" + requestParams);
                
        String Chosen_Data_View = requestParams.get("chosen_data_view");
        
        ArrayList<Shares> response = new ArrayList<Shares>();
                
        //Returns record with highest listed share value
        if ("Highest Share Value".equals(Chosen_Data_View))
        {
            JAXBContext context = JAXBContext.newInstance(SharesList.class);
            Unmarshaller um = context.createUnmarshaller();
            SharesList sharelist2 = (SharesList) um.unmarshal(Shares_File);
            ArrayList<Shares> unmarshlist = sharelist2.getBooksList();
            
            int record = 0;
            
            for (Shares share : unmarshlist)
            {                
                if ((share.getSharePrice().getValue()) > record)
                {
                    response.clear();
                    response.add(share);
                }
            }
        }
        
        //Returns record with highest listed share amount
        else if ("Highest Share Amount".equals(Chosen_Data_View))
        {
            JAXBContext context = JAXBContext.newInstance(SharesList.class);
            Unmarshaller um = context.createUnmarshaller();
            SharesList sharelist2 = (SharesList) um.unmarshal(Shares_File);
            ArrayList<Shares> unmarshlist = sharelist2.getBooksList();
            
            int record = 0;
            
            for (Shares share : unmarshlist)
            {                
                if ((share.getNumOfShares()) > record)
                {
                    response.clear();
                    response.add(share);
                }
            }
        }
        
        //Returns share with lowest listed share value
        else if ("Lowest Share Value".equals(Chosen_Data_View))
        {
            JAXBContext context = JAXBContext.newInstance(SharesList.class);
            Unmarshaller um = context.createUnmarshaller();
            SharesList sharelist2 = (SharesList) um.unmarshal(Shares_File);
            ArrayList<Shares> unmarshlist = sharelist2.getBooksList();
            
            float record = 12f;
            
            for (Shares share : unmarshlist)
            {
                record = share.getSharePrice().getValue();
                break;
            }
            
            for (Shares share : unmarshlist)
            {                
                if ((share.getSharePrice().getValue()) <= record)
                {
                    response.clear();
                    response.add(share);
                }
            }
        }
        
        //Returns record with lowest listed share amount. 
        else if ("Lowest Share Amount".equals(Chosen_Data_View))
        {
            JAXBContext context = JAXBContext.newInstance(SharesList.class);
            Unmarshaller um = context.createUnmarshaller();
            SharesList sharelist2 = (SharesList) um.unmarshal(Shares_File);
            ArrayList<Shares> unmarshlist = sharelist2.getBooksList();
            
            int record = 123;
            
            for (Shares share : unmarshlist)
            {
                record = share.getNumOfShares();
                break;
            }
            
            for (Shares share : unmarshlist)
            {                
                if ((share.getNumOfShares()) <= record)
                {
                    response.clear();
                    response.add(share);
                }
            }
        }
        
        return response;
    }
}
