//Client Application that users can see and interact with. 

package shares_system_client_application;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;    
import java.time.ZoneId;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

//@XmlRootElement(name = "Shares")
public class Shares_System_Client_Application
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        Shares_Add_Page Share_Create = new Shares_Add_Page();
        Share_Create.setVisible(true);
        
        /*
        File Shares_File = new File("Shares_Data.xml");
        
        //Creates instance of binded XML file.
        //Shares_Info = Package name
        //CurrentShares = bound XML file
        Shares_Info.CurrentShares quickXML = new Shares_Info.CurrentShares();
                
        quickXML.setCompanyName("test co");
        quickXML.setCompanySymbol("POUND");
        
        Date now = new Date();
        Instant current = now.toInstant();
        LocalDateTime ldt = LocalDateTime.ofInstant(current, ZoneId.systemDefault());
                
        String dateTimeString = ldt.toString();

        try
        {
            XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTimeString);
            
            quickXML.setLastShareUpdate(date2);

        }
        
        catch (Exception e)
        {
             System.out.println("Oopsie Poopsie");
        }
        
        quickXML.setNumOfShares(43000);
        
        Shares_Info.CurrentShares.SharePrice quickXML2 = new Shares_Info.CurrentShares.SharePrice();
        quickXML2.setCurrency("Dollar");
                
        quickXML2.setValue(123.4f);
        
        quickXML.setSharePrice(quickXML2);
       
        
        //Marshelling code
        try 
        {   
            //The JAXBContext class provides the client's entry point to the JAXB API
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(quickXML.getClass().getPackage().getName());

            //The Marshaller class is responsible for governing the process of 
            //serializing Java content trees back into XML data
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();

            //Specified encoding
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N

            //The name of the property used to specify whether or not the 
            //marshalled XML data is formatted with linefeeds and indentation.
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);                     

            marshaller.marshal(quickXML, Shares_File);
        }

        catch (javax.xml.bind.JAXBException ex) 
        {            
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        */
    }
}
