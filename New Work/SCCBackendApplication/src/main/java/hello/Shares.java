package hello;



import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "share")
// If you want you can define the order in which the fields are written
@XmlType(propOrder = { "companyName", "companySymbol", "numOfShares", "lastShareUpdate", "sharePrice" }) // Order of XML schema data
public class Shares 
{
    private String company_name;
    private String company_symbol;
    private int num_of_shares;
    private Date last_share_update;
    private SharePrice shareprice;

    // If you like the variable company_name, e.g. "company_name", you can easily change this
    // company_name for your XML-Output:
    @XmlElement(name = "title")
    public String getCompanyName() 
    {
        return company_name;
    }

    public void setCompanyName(String company_name) 
    {
        this.company_name = company_name;
    }

    public String getCompanySymbol() 
    {
        return company_symbol;
    }

    public void setCompanySymbol(String company_symbol) 
    {
        this.company_symbol = company_symbol;
    }

    public int getNumOfShares() 
    {
        return num_of_shares;
    }

    public void setNumOfShares(int num_of_shares) 
    {
        this.num_of_shares = num_of_shares;
    }

    public Date getLastShareUpdate() 
    {
        return last_share_update;
    }

    public void setLastShareUpdate(Date last_share_update) 
    {
        this.last_share_update = last_share_update;
    }
    
    public SharePrice getSharePrice() 
    {
        return shareprice;
    }

    public void setSharePrice(SharePrice shareprice) 
    {
        this.shareprice = shareprice;
    }
}