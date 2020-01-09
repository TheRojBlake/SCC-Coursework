
/*
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController is a convenience annotation for creating Restful controllers. 
//It is a specialization of @Component and is autodetected through classpath 
//scanning. It adds the @Controller and @ResponseBody annotations. It converts 
//the response to JSON or XML.
@CrossOrigin (origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ApiControllerOld
{ 
    File Shares_File = new File("Shares_Data.xml");
    ArrayList<Shares> shareList = new ArrayList<Shares>();
    
    //Used to map web requests to Spring Controller methods
    //value - specified URL path of request
    //produces - specified the request mapping types
    @RequestMapping(value="/api/getData", produces="application/JSON")
    public Object getData()
    {   
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
        shareList.add(share1);
        
        SharesList sharelist = new SharesList();
        sharelist.setBookList(shareList);
        
        /*
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
       

        return share1;
    }
}*/
