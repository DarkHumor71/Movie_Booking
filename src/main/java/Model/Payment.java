/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author moudy
 */
public class Payment {
    private String name;
    private String time;private double amount;

    public Payment(String name,double amount,String time) {
        this.name = name;
       this.time=time;
        this.amount = amount;
    }
     public Payment(double amount,String time) {//read book
        this.name = name;
	this.time=time;               
        this.amount = amount;
    }
      public Payment(double amount) {//addbook
        
			SimpleDateFormat d = new SimpleDateFormat("dd / MM / yyyy HH:mm:ss");
                        TimeZone tz = TimeZone.getTimeZone("Etc/GMT+2");
			Calendar c = Calendar.getInstance(tz);
			try{this.time=d.parse(d.format(c.getTime())).toString();
                        }catch(Exception e){
                            
                        }
        this.amount = amount;
    }
       public Payment(String name,double amount) {//add pay
        
			SimpleDateFormat d = new SimpleDateFormat("dd / MM / yyyy HH:mm:ss");
                        TimeZone tz = TimeZone.getTimeZone("Etc/GMT+2");
			Calendar c = Calendar.getInstance(tz);
                       
			try{this.time=d.parse(d.format(c.getTime())).toString();
                        }catch(Exception e){
                            
                        }
        this.amount = amount;
        this.name=name;
    }
     
    @Override
    public String toString() {
        if(name==null&&time==null){
            return amount+"\n";
        }else if(name==null){
            return amount+
                   ","+time+"\n";
        }else if(time==null){
            return name+","+amount+"\n";
        }
        return  name + ","  + amount+","+ time +"\n" ;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public double getAmount() {
        return amount;
    }
    
}
