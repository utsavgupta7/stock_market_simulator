package stock_market;

import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class filereader 
{
    //D:/study/netbeans_projects/StockMarket/build/web/
   File file=new File("stocks.html");
   FileReader fr = null;
   
   String s;
   void update()
    {
        String s_final="<table border='1'><tr><td>company</td><td>price\n",s_new="";
        try 
        {
            fr = new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            while((s=br.readLine())!=null)
            {
                int j=s.indexOf("> ");
                if(j==-1)
                    continue;
                double initial=Double.parseDouble(s.substring(j+2));
                double new_value=initial+(5*(new Random().nextDouble())-2.5);
                double change=new_value-initial;
                if(change>0)
                {
                   int start=s.indexOf("='");
                   s_new=s.substring(0,start+2)+"green'> "+String.valueOf(new_value).substring(0,5);
                }
                else
                {
                   int start=s.indexOf("='");
                   s_new=s.substring(0,start+2)+"red'> "+String.valueOf(new_value).substring(0,5);
                }
                s_final=s_final+s_new+"\n";
            }
        } 
        catch(FileNotFoundException f)
        {
            System.out.println("class not found");
        }
        catch(IOException i)
        {
            System.out.println("io exception");
        }
        try
        {
            BufferedWriter bw = null;
            bw=new BufferedWriter(new FileWriter(file));
            s_final=s_final+"</font></td></tr></table>";
            bw.write(s_final);
            System.out.println(s_final);
            bw.close();
            fr.close();
        }
        catch(Exception ex)
        {
            System.out.println("exception in writing");
        }
      }        
}
