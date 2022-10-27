/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
//import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *
 * @author Ismail
 */
public class SmsSender {
    public void sendSms(String sToPhoneNo,String sMessage)
       {
          try 
          {
           // Construct data
           String data = "user=" + URLEncoder.encode("textlocalusername****", "UTF-8");
           data += "&password=" + URLEncoder.encode("textlocalpassword****", "UTF-8");
           data += "&message=" + URLEncoder.encode(sMessage, "UTF-8");
           data += "&sender=" + URLEncoder.encode("OPTINS", "UTF-8");
           data += "&mobile=" + URLEncoder.encode(sToPhoneNo, "UTF-8");
              System.out.println("Desktop.services.SmsSender.sendSms()");
      //     data += "&type=" + URLEncoder.encode(0b1, "UTF-8");
           // Send data
           URL url = new URL("https://api.movider.co/v1/sms");
           URLConnection conn = url.openConnection();
           conn.setDoOutput(true);
           OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
           wr.write(data);
           wr.flush();
           // Get the response
           BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
           String line;
           String sResult="";
           while ((line = rd.readLine()) != null) 
           {
                 // Process line...
                 sResult=sResult+line+" ";
           }
           wr.close();
           rd.close();

          } 
               catch (Exception e) 
               {
                  System.out.println("Error SMS "+e);

               }
        }

    
}
