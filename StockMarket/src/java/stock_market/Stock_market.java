package stock_market;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Stock_market implements Runnable
{
    Thread t;
    public Stock_market()
    {
        t=new Thread(this,"company");
        t.start();
    }
    
    public void run()
    {
        filereader obj_file=new filereader();
        try 
        {
            for(int i=1;i>0;i++)
            {
                obj_file.update();
                t.sleep(2000);
            }
            
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(Stock_market.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void main(String[] args) 
    {
          Stock_market obj=new Stock_market();   
          
    }
}
