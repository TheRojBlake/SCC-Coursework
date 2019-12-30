package shares_system_client_application;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Instant;
import java.time.LocalDateTime;    
import java.time.ZoneId;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement
public class Shares_System_Client_Application
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        Shares_Info.CurrentShares quickXML = new Shares_Info.CurrentShares();
        
        quickXML.setCompanyName("test co");
        quickXML.setCompanySymbol("DOLLAR");
        
        Date now = new Date();
        Instant current = now.toInstant();
        LocalDateTime ldt = LocalDateTime.ofInstant(current, ZoneId.systemDefault());
        
        System.out.println(ldt);
        
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
        
        try 
        {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(quickXML.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(quickXML, System.out);
            marshaller.marshal(quickXML2, System.out);
            OutputStream os = new FileOutputStream("Share_Data.xml"); //Outputs data to file
            os.close();
        } 
        
        catch (javax.xml.bind.JAXBException ex) 
        {            
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }             
        
    }
}
