package Proj_Backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionWS_V2 
{
    //An enum is a special "class" that represents a group of constants 
    //(unchangeable variables, like final variables).
    //List of different exchange rates and amounts
    public enum ExchangeRate 
    {
        AED ("UAE Dirham", 0.168577),
        ARS ("Argentine Peso", 0.15464),
        AUD ("Australian Dollar", 0.615118),
        BGN ("Bulgarian Lev", 0.437263),
        BRL ("Brazilian Real", 0.36452),
        BWP ("Botswana Pula", 0.0945012),
        CAD ("Canadian Dollar", 0.612737),
        CHF ("Swiss Franc", 0.628501),
        CLP ("Chilean Peso", 0.00130255),
        CNY ("Chinese Yuan", 0.0941966),
        COP ("Colombian Peso", 0.000333297),
        DKK ("Danish Krone", 0.114709),
        EEK ("Estonian Kroon", 0.0546572),
        EGP ("Egypt Pounds", 0.107657),
        EUR ("Euro", 0.855201),
        GBP ("British pound", 1.0),
        HKD ("Hong Kong Dollar", 0.0806557),
        HRK ("Croatian Kuna", 0.115641),
        HUF ("Hungarian Forint", 0.00311833),
        ILS ("Israeli New Shekel", 0.17155),
        INR ("Indian Rupee", 0.0137968),
        ISK ("Iceland Krona", 0.00554904),
        JPY ("Japanese Yen", 0.00749584),
        KRW ("South Korean Won", 0.000552922),
        KZT ("Kazakhstani Tenge", 0.00424244),
        LKR ("Sri Lanka Rupee", 0.00559926),
        LTL ("Lithuanian Litas", 0.247684),
        LVL ("Latvian Lat", 1.2057),
        LYD ("Libyan Dinar", 0.32365),
        MXN ("Mexican Peso", 0.0508402),
        MYR ("Malaysian Ringgit", 0.200469),
        NOK ("Norwegian Kroner", 0.104293),
        NPR ("Nepalese Rupee", 0.0086265),
        NZD ("New Zealand Dollar", 0.485357),
        OMR ("Omani Rial", 1.62658),
        PKR ("Pakistan Rupee", 0.00732149),
        QAR ("Qatari Rial", 0.171819),
        RON ("Romanian Leu", 0.198977),
        RUB ("Russian Ruble", 0.0201399),
        SAR ("Saudi Riyal", 0.166779),
        SDG ("Sudanese Pound",0.260967),
        SEK ("Swedish Krona", 0.091032),
        SGD ("Singapore Dollar", 0.481964),
        THB ("Thai Baht", 0.0208891),
        TRY ("Turkish Lira", 0.432246),
        TTD ("Trinidad/Tobago Dollar", 0.098396),
        TWD ("Taiwan Dollar", 0.0206288),
        UAH ("Ukrainian hryvnia", 0.077864),
        USD ("United States Dollar", 0.625421),
        VEB ("Venezuelan Bolivar", 0.145633),
        ZAR ("South African Rand", 0.0893935);

        private final double rate_In_GBP;
        private final String currency_Name;
        
        //Gets passed two variables and assigns them to above values. 
        ExchangeRate(String currency_Name, double rate_In_GBP) 
        {
            this.rate_In_GBP = rate_In_GBP; //
            this.currency_Name = currency_Name; //Currency user wishes to convert to. 
        }
        
        double rate_In_GBP()
        { 
            return rate_In_GBP; 
        }
        
        String currency_Name()
        { 
            return currency_Name; 
        }
    }
    
    //Gets passed two currencies and returns conversion rate of them.
    //First value is currency of variable, second is chosen currency
    @CrossOrigin(origins = "http://localhost:4200")   
    @PostMapping(path = "/CurrConvRequest")
    public double GetConversionRate(@RequestParam Map<String, String> requestParams) 
    {        
        String chosen_Currency_1 = requestParams.get("current_currency");
        String chosen_Currency_2 = requestParams.get("change_currency");
        
        String[] _arr = chosen_Currency_1.split("\\s");
        chosen_Currency_1 = _arr[0];
                
        String[] _arr_2 = chosen_Currency_2.split("\\s");
        chosen_Currency_2 = _arr_2[0];
                
        try 
        {            
            double rate1 = ExchangeRate.valueOf(chosen_Currency_1).rate_In_GBP;
            
            double rate2 = ExchangeRate.valueOf(chosen_Currency_2).rate_In_GBP;
            return rate1/rate2;
        }
        
        catch (IllegalArgumentException iae) 
        {
            return -1; //Handles errors
        }  
    }
    
    //Passes codes to list and returns it to frontend
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/currconvcodes", method = RequestMethod.GET, produces="application/json")
    public List<String> GetCurrencyCodes() 
    {
        List<String> list_Of_Codes = new ArrayList(); //List of strings containing all exchange codes. 
        for (ExchangeRate exr : ExchangeRate.values()) //For each code in ExchangeRate
        {
            list_Of_Codes.add(exr.name() + " - " + exr.currency_Name); //Adds name + 
        }
        
        return list_Of_Codes;
    }
}
